package com.intelli.linksharing


class User {

    String email
    String username
    String password
    String firstName
    String lastName
    Byte[] photo
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated
    String confirmPassword


    static transients = ['name', 'confirmPassword']

    static hasMany = [topics: Topic, subscriptions: Subscription, readingItems: ReadingItem, resources: Resource]

    static constraints = {
        email unique: true, email: true, blank: false
        username unique: true
        password blank: false, minSize: 5
        firstName blank: false
        lastName blank: false
        photo nullable: true
        admin nullable: true
        active nullable: true
        confirmPassword bindable: true, nullable: true, blank: true, validator: { val, obj ->
            if(!obj.id){
                if (val == null) return 'confirm password is null'
                if (!val.equals(obj.password)) return 'confirm password did not match with password'
            }
        }
    }


    static mapping = {
        photo sqlType: "longblob"
        sort id: 'desc'
    }

    String getName() {
        "${firstName} ${lastName}"
    }

    @Override
    String toString() {
        username
    }
}
