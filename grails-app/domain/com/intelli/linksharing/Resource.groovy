package com.intelli.linksharing

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

    static mapping = {
        description type: 'text'
    }


}
