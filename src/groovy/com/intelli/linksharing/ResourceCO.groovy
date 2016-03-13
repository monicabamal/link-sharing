package com.intelli.linksharing

import grails.validation.Validateable

@Validateable
class ResourceCO {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated


    static constraints = {
        description size: 100..1024
    }


}
