package com.intelli.linksharing

import com.intelli.linksharing.enums.Seriousness
import com.intelli.linksharing.enums.Visibility
import com.intelli.linksharing.vo.TopicVO

class Topic {

    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility

    static hasMany = [subscriptions: Subscription, resources: Resource]

    static constraints = {
        name blank: false, unique: ["createdBy"]
        visibility inList: Visibility.values().toList()
    }

    static mapping = {
        sort "name"
    }

    def afterInsert() {
        log.info("automatically subscribing user created topics to that user")
        log.info("User - ${createdBy}, Topic - ${name}")
        Subscription.withNewSession {
            new Subscription(topic: this, user: createdBy, seriousness: Seriousness.VERY_SERIOUS).save()
        }
        Subscription.validationErrorsMap.size() == 0 ? log.info("subscription successful") : log.error("subscription fail for user - ${createdBy}, topic - ${name} ")
    }

    String toString() {
        name
    }

    static getTrendingTopics() {

        List<TopicVO> topicVOs = []
        List<Topic> topics = Topic.createCriteria().list(max: 5) {

            eq(visibility, Visibility.PUBLIC)
            order(resources.size(), desc)
            order(name)
        }

        topics.each { topic ->
            TopicVO topicVO = new TopicVO()
            topicVO.visibility = topic.visibility
            topicVO.count = topic.resources.size()
            topicVO.createdBy = topic.createdBy
            topicVO.id = topic.id
            topicVO.name = topic.name
            topicVOs.add(topicVO)
        }

        topicVOs

    }


}
