package com.intelli.linksharing

class Subscription {

    enum SeriousnessType{
       CASUAL
    }

    User user
    Topic topic
    SeriousnessType seriousness
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user unique: ['topic']
    }
}
