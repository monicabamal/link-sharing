package com.intelli.linksharing

class Subscription {

    Topic topic
    User user
    Seriousness seriousness=Seriousness.CASUAL
    Date dateCreated

    static belongsTo = [user: User, topic:Topic]

    static constraints = {
        user unique: 'topic'

    }

    def afterInsert={
        withNewSession {
            Resource[] resources=Resource.findAllByTopic(this.topic)
            resources.each { Resource resource->
                new ReadingItem(resource : resource, user: this.user, isRead: false).save()
            }

        }

    }

    static namedQueries = {
        subscribedTopics{ User user ->
            projections {
                property('topic')
            }
            eq('user',user)

        }

        seriousEmployee{projections {
            'topic'{
                property('name')
            }
            'user'{
                property('email')
            }
        }
            eq('seriousness',Seriousness.SERIOUS)
        }

        verySeriousEmployee{projections {
            'topic'{
                property('name')
            }
            'user'{
                property('email')
            }
        }
            eq('seriousness',Seriousness.VERYSERIOUS)
        }


    }




}
