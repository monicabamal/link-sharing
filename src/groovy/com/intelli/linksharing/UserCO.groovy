package com.intelli.linksharing

import grails.validation.Validateable


@Validateable
class UserCO {

    String email
    String userName
    String password
    String rePassword
    String firstName
    String lastName
    String name
    boolean admin
    boolean active
    Date dateCreated
    Date lastUpdated
    byte[] photo
    Set resourceRating
    Set topic
    Set subscription
    Set readingItem
    Set resource


    static constraints = {

        userName size: 5..15, blank: false, unique: true
        password size: 5..15, blank: false
        password size: 5..15, blank: false
        password size: 6..20
        email email: true, blank: false, unique: true
        firstName blank: false
        password validator: { val, obj ->
            if (!val.equals(obj.rePassword))
                return "invalid"
        }


    }


}
