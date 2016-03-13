package com.intelli.linksharing

class Topic {
    String name
    String description
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility

    static belongsTo = [ createdBy : User ]
    static hasMany = [subscription: Subscription, resource: Resource]

    static mapping = {
        sort dateCreated: 'desc'
    }

            static constraints = {
                name blank: false , unique: 'createdBy' , size: 2..20

    }

    def afterInsert={
        withNewSession {

            new Subscription(user: createdBy , topic: this,seriousness: Seriousness.CASUAL).save()
        }

    }

    static namedQueries = {
        topUpdatedTopics { User user->
            'subscription'{
                eq("user",user)}

            'resource'{
                order("dateCreated","desc")
            }
        }

        searchTopic{String key->
                or{ ilike('name',"%${key}%")
                    ilike('description',"%${key}%")
                }
                eq('visibility',Visibility.PUBLIC)
            }

    }

}
