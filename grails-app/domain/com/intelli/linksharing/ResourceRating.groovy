package com.intelli.linksharing

class ResourceRating {

    Resource resource
    User user
    Integer score

    static constraints = {
        score min: 1,max: 5
        resource unique: ['user']
    }
}
