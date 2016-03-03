package com.intelli.linksharing

import com.intelli.linksharing.enums.Seriousness
import com.intelli.linksharing.enums.Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

class SubscriptionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "check topic subscription uniqueness per user"() {

        setup: "user created topic"
        String topicName = "grails"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",confirmPassword: "igdefault", firstName: "monica",lastName: "bamal");
        Topic topic = new Topic(name: topicName, visibility: Visibility.PUBLIC, createdBy: user)
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: Seriousness.CASUAL)

        when:
        subscription.save(flush: true)

        then:
        Subscription.count() == 1

        when:
        Subscription subscriptionNew = new Subscription(topic: topic, user: user, seriousness: Seriousness.CASUAL)
        subscriptionNew.save(flush: true)

        then:
        Subscription.count() == 1
        subscriptionNew.errors.allErrors.size() == 1
        subscriptionNew.errors.getFieldErrorCount('user') == 1

    }
}
