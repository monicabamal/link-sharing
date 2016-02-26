package com.intelli.linksharing

import enums.Seriousness
import enums.Visibility

class Topic {

    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility

    static  hasMany = [subscriptions: Subscription,resources: Resource]

    static constraints = {
        name  blank: false, unique: ["createdBy"]
        visibility inList: Visibility.values().toList()
    }

    def afterInsert(){
        log.info("automatically subscribing user created topics to that user")
        log.info("User - ${createdBy}, Topic - ${name}")
        Subscription.withNewSession {
            new Subscription(topic: this, user:createdBy, seriousness: Seriousness.VERY_SERIOUS).save()
        }
        Subscription.validationErrorsMap.size() == 0 ?log.info("subscription successful"):log.error("subscription fail for user - ${createdBy}, topic - ${name} ")
    }

    String toString(){
        name
    }

}
