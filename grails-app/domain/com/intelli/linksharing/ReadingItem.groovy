package com.intelli.linksharing

class ReadingItem {

    User user
    Boolean isRead
    Resource resource
    Date dateCreated
    Date lastUpdated

    static constraints = {
        resource unique: ['user']
    }
}
