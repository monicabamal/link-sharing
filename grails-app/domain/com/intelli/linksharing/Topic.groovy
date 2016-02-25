package com.intelli.linksharing

import enums.Visibility

class Topic {

    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility = Visibility.PUBLIC

    static  hasMany = [subscriptions: Subscription,resources: Resource]

    static constraints = {
        name  blank: false, unique: ["createdBy"]
        visibility inList: Visibility.values().toList()
    }
}
