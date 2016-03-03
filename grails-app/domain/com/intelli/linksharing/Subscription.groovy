package com.intelli.linksharing

import com.intelli.linksharing.enums.Seriousness

class Subscription {

    Topic topic
    User user
    Seriousness seriousness = Seriousness.SERIOUS
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user unique: ['topic']
    }

    static mapping = {
        topic lazy: false
        user lazy: false
    }
}
