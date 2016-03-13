package com.intelli.linksharing

class ResourceRating {
    Resource resource
    User user
    Integer score

    static belongsTo = [user: User, resource: Resource]

    static constraints = {
        resource unique: 'user'
        score size:0..5
    }


    static namedQueries = {
        topRatedResource {
            projections {
                groupProperty('resource','resource')
                avg('score','avgScore')
            }
            order('avgScore','desc')
        }
    }

}
