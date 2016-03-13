package com.intelli.linksharing

import grails.validation.Validateable

@Validateable
class TopicCO {
    Long id
    String name
    String description
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    Set subscription
    Set resource


}
