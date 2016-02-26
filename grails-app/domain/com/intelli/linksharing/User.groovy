package com.intelli.linksharing

import com.mysql.jdbc.Blob


class User {

    String email
    String username
    String password
    String firstName
    String lastName
    Byte []photo
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated

    static transients = ['name','confirmpassword']

    static  hasMany = [topics: Topic,subscriptions: Subscription,readingItems: ReadingItem,resources: Resource]

    static constraints = {
        email unique: true, email: true, blank: false
        username unique: true
        password  blank: false, minSize: 5
        firstName blank: false
        lastName  blank: false
        photo nullable: true
        admin nullable: true
        active nullable: true

      /*  confirmpassword bindable:true, validator:{val, obj ->
                                                    if(!session.user){
                                                       if(val != obj.password)  return 'confirm password did not match with pasword'
                                                        if(val == null) return 'confirm password is null'
                                                    }
                                                }*/
    }

    static mapping = {
        photo sqlType: "longblob"
    }

    String getName(){
        "${firstName} ${lastName}"
    }

    @Override
    String toString(){
        username
    }
}
