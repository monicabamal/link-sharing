import com.intelli.linksharing.DocumentResource
import com.intelli.linksharing.LinkResource
import com.intelli.linksharing.ReadingItem
import com.intelli.linksharing.Resource
import com.intelli.linksharing.ResourceRating
import com.intelli.linksharing.Subscription
import com.intelli.linksharing.Topic
import com.intelli.linksharing.User
import com.intelli.linksharing.enums.Seriousness
import com.intelli.linksharing.enums.Visibility
import groovy.LinkSharingConstants

class BootStrap {

    def grailsApplication



    def init = { servletContext ->
        println  "External file property -->> "+grailsApplication.config.project
        log.info("Initializing dummy data before launching application.. ")
        createUsers()
        createTopics()
        createResources()
        subscribeTopics()
        createReadingItems()
        createResourceRatings()
    }

    def destroy = {
    }

    def createUsers(){
        if(!User.count) {
            log.info("No user found in records")
            log.info("creating 1 admin..")
            User admin = new User(email: 'admin@gmail.com', password: LinkSharingConstants.DEFAULT_PASSWORD,confirmPassword: LinkSharingConstants.DEFAULT_PASSWORD, firstName: 'monica', lastName: 'bamal',
                    username: 'monicabamal', admin: true, active: true)
            admin.save(failOnError: true, flush: true)
            log.info('1 admin is created')
            log.info("creating 1 normal user..")
            User normalUser = new User(email: 'normal@gmail.com', password: LinkSharingConstants.DEFAULT_PASSWORD, confirmPassword: LinkSharingConstants.DEFAULT_PASSWORD, firstName: 'monica1', lastName: 'bamal1',
                    username: 'monicabamal1', admin: false, active: true )
            normalUser.save(failOnError: true,flush: true)
            log.info('1 normal user is created')
        }
    }

    def createTopics(){
        if(!Topic.count){
            log.info("No topic found in database. So creating new..")
            List<Topic> topics = []
            User.list().each { user ->
                5.times {
                    topics.add(new Topic(name: "topic${it}", createdBy:user, visibility: Visibility.PRIVATE ))
                }
            }
            Topic.saveAll(topics)
            Topic.validationErrorsMap.size() == 0 ? log.info("All topics created successfully "):log.error("Error in creating topics")
        }
    }

    def createResources(){
        if(!Resource.count){
            log.info("No resource found in database. So creating new..")
            List<Resource> resources = []
            Topic.list().each { topic ->
                2.times{
                    resources.add(new DocumentResource(description: topic.name,createdBy: topic.createdBy,topic: topic,
                            filepath: "/home/user"))
                    resources.add(new LinkResource(description: topic.name,createdBy: topic.createdBy,topic: topic,
                           url: "https://www.google.com"))
                }
            }
            Resource.saveAll(resources)
            Resource.validationErrorsMap.size() == 0 ? log.info("All resources created successfully "):log.error("Error in creating resources")
        }
    }

    def subscribeTopics(){
        List<Subscription> subscriptions = []
        log.info("Subscribing all users to all topics that are not created by user itself..")
        User.list().each { user ->
            Topic.findAllByCreatedByNotEqual(user).each { topic ->
                if(!Subscription.findByUserAndTopic(user, topic)){
                    subscriptions.add(new Subscription(topic:topic, user:user, seriousness: Seriousness.VERY_SERIOUS))
                }
            }
        }
        Subscription.saveAll(subscriptions)
        Subscription.validationErrorsMap.size() == 0 ? log.info("All user are subscribed to all topics"):log.error("Error in subscribing all topics to all users")
    }

    def createReadingItems(){
        log.info("Creating dummy reading items for the resources of subscribed topics of user that are not created by user..")
        List<ReadingItem> readingItems = []
        User.list().each { user ->
            Subscription.findAllByUser(user).each {subscription ->
                Resource.findAllByCreatedByNotEqualAndTopic(subscription.topic.createdBy, subscription.topic).each { resource ->
                    if(!ReadingItem.findByResourceAndUser(resource, user)){
                        readingItems.add(new ReadingItem(user: user, resource: resource, isRead: false))
                    }
                }
            }
        }
        ReadingItem.saveAll(readingItems)
        ReadingItem.validationErrorsMap.size() == 0 ? log.info("Reading items for resources of all the subscribed topics are added successfully"):log.error("Error in adding reading items for resources of all the subscribed topics")
    }

    def  createResourceRatings(){
        log.info("Adding resource rating for all resources that are not read by user")
        List<ResourceRating> resourceRatingList = []
        ReadingItem.findAllByIsRead(false).each { resourceItem ->
            if(!ResourceRating.findByResourceAndUser(resourceItem.resource,resourceItem.user))
                resourceRatingList.add(new ResourceRating(resource: resourceItem.resource, user: resourceItem.user, score: 5))
        }
        ResourceRating.saveAll(resourceRatingList)
        ResourceRating.validationErrorsMap.size() == 0? log.info("Rating added to all resource successfully"):log.error("Error in adding rating to resources")
    }
}
