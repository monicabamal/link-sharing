package com.intelli.linksharing

class User {
    String email
    String userName
    String password
    String firstName
    String lastName
    String name
    boolean admin
    boolean active
    Date dateCreated
    Date lastUpdated
    byte[] photo

    static transients = ['name']

    static hasMany = [topic: Topic, subscription: Subscription, readingItem: ReadingItem, resourceRating: ResourceRating, resource: Resource]


    static constraints = {

        userName size: 5..15, blank: false, unique: true
        password size: 5..15, blank: false
        password size: 5..15, blank: false
        password size: 6..20
        email email: true, blank: false, unique: true
        firstName blank: false
    }

    static mapping = {

        photo column: 'photo', sqlType: 'VARBINARY(10000)'
    }


    def getName() {
        return "${firstName} ${lastName ?: ""}";
    }
}
