package com.intelli.linksharing

abstract class Resource {

    User createdBy
    String description
    Topic topic
    Date dateCreated
    Date lastUpdated

    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

    static mapping = {
        description type: 'text'
    }


}
