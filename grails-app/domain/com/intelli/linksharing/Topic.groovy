package com.intelli.linksharing

import org.apache.commons.lang.enums.Enum

class Topic {

    enum VisibilityType {
        PUBLIC,
        PRIVATE,
        DEFAULT,
        NONE
    }

    String name
    VisibilityType visibility = VisibilityType.DEFAULT
    User createdBy
    Date dateCreated
    Date lastUpdated

    static  hasMany = [subscriptions: Subscription,resources: Resource]

    static constraints = {
        name  blank: false, unique: ['createdBy']
        visibility inList: VisibilityType.values().toList()
    }
}
