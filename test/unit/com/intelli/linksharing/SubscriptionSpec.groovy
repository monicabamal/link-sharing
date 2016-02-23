package com.intelli.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Subscription)
class SubscriptionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {

        setup: "user created topic"
        String topicName = "grails"
        User user = new User(firstName: "monica", lastName: "bamal", email: "asd@b.com", password: "qwerty", username: "abc")
        Topic topic = new Topic(name: topicName, visibility: Topic.VisibilityType.PUBLIC, createdBy: user)
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: Subscription.SeriousnessType.CASUAL)



        when:
        subscription.save()
        subscription.errors.allErrors.each {
            println it
        }
        println subscription.errors


        then:
        subscription.count() == 1

        when:
        Subscription subscriptionNew = new Subscription(topic: topic, user: user, seriousness: Subscription.SeriousnessType.CASUAL)
        subscriptionNew.save()

        then:
        subscription.count() == 1
        subscriptionNew.errors.allErrors.size() == 1
        subscriptionNew.errors.getFieldErrorCount('user') == 1
    }
}
