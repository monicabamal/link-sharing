package com.intelli.linksharing

import com.mysql.jdbc.Blob


class User {

    String email
    String password
    String firstName
    String lastName
    Byte []photo
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated

    static transients = ['name']

    static  hasMany = [topics: Topic,subscriptions: Subscription,readingItems: ReadingItem,resources: Resource]

    static constraints = {
        email unique: true, email: true, blank: false
        password  blank: false, minSize: 5
        firstName blank: false
        lastName  blank: false
        photo nullable: true
        admin nullable: true
        active nullable: true
    }

    static mapping = {
        photo sqlType: 'LONGBLOB'
    }

    String getName(){
        "$firstName $lastName"
    }
}
