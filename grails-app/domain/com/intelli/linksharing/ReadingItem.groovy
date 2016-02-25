package com.intelli.linksharing

class ReadingItem {

    Resource resource
    User user
    Boolean isRead

    static constraints = {
        resource unique: ['user']
    }
}
