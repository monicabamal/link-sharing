package com.intelli.linksharing

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
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

    @IgnoreRest
    void "check topic subscription uniqueness per user"() {

        setup: "user created topic"
        String topicName = "grails"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        Topic topic = new Topic(name: topicName, visibility: enums.Visibility.PUBLIC, createdBy: user)
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: enums.Seriousness.CASUAL)

        when:
        subscription.save(flush: true)

        then:
        Subscription.count() == 1

        when:
        Subscription subscriptionNew = new Subscription(topic: topic, user: user, seriousness: enums.Seriousness.CASUAL)
        subscriptionNew.save(flush: true)

        then:
        Subscription.count() == 1
        subscriptionNew.errors.allErrors.size() == 1
        subscriptionNew.errors.getFieldErrorCount('user') == 1

    }
}
