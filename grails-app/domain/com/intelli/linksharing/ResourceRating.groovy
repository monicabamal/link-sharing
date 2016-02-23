package com.intelli.linksharing

class ResourceRating {

    final User createdBy
    int score
    Resource resource
    Date dateCreated
    Date lastUpdated

    static constraints = {
        score min: 1,max: 5
        resource unique: ['createdBy']
    }
}
