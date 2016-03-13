package com.intelli.linksharing

abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static belongsTo = [topic : Topic]

    static hasMany = [readingItems: ReadingItem, resourceRatings: ResourceRating]

    static mapping = {
        tablePerHierarchy false
        sort dateCreated: 'desc'
        description column: 'description', sqlType: 'text'
    }

    static constraints = {
        description size: 100..1024
    }

    def afterInsert= {
        withNewSession {
            Subscription[] subscriptions = Subscription.findAllByTopic(this.topic)
            subscriptions.each { Subscription subscription ->
                new ReadingItem(resource: this, user: subscription.user, isRead: false).save()
            }

        }

    }

    static namedQueries = {
        recentPublicResources{
            'topic'{
                eq('visibility',Visibility.PUBLIC)
            }
            order('dateCreated','desc')

        }


    }




}
