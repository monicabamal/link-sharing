package com.intelli.linksharing

import enums.Seriousness

class Subscription implements  Serializable{

    Topic topic
    User user
    Seriousness seriousness
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user unique: ['topic']
    }
}
