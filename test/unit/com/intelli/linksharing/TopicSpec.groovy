package com.intelli.linksharing

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test topic uniqueness per user"() {

        given: ""
        String topicName = "Grails";
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault", confirmPassword: "igdefault",firstName: "monica",lastName: "bamal");
        Topic topic = new Topic(name: topicName, createdBy: user, visibility: com.intelli.linksharing.enums.Visibility.PUBLIC);

        when: "topic will save"
        topic.save(flush: true);

        then: "check whether topic is saved or not"
        topic.count() == 1;

        when: "topic with same name"
        Topic newTopic = new Topic(name: topicName, createdBy: user, visibility: com.intelli.linksharing.enums.Visibility.PUBLIC);
        newTopic.save(flush: true);

        then:
        topic.count() == 1;
        newTopic.errors.allErrors.size() == 1;
        newTopic.errors.getFieldErrorCount('name') == 1;


    }

    def "Visibility should not be null & must be enum"() {
        setup: "user created topic"
        Topic topic = new Topic(name: name, visibility: visibility)

        when: "check for validation"
        Boolean result = topic.validate()

        then: "test the result"
        result == valid

        where: "trying different values"

        sno | name     | visibility | valid
        1   | "grails" | " "        | false
        2   | "java"   | null       | false
        3   | "grails" | "PUBLIC"   | false
        4   | "grails" | "PRIVATE"  | false
        5   | ""       | "xyz"      | false
        5   | null     | "xyz"      | false
        5   | "grails" | "xyz"      | false

    }

    def "check toString method"() {

        given:
        Topic topic = new Topic(name: name)

        expect:
        topic.toString() == result

        where:
        sno | name     | result
        1   | "topic1" | "topic1"
        2   | "topic2" | "topic2"


    }

    def "convert string to enum"() {

        when:
        Enum value = com.intelli.linksharing.enums.Visibility.toEnum(string)

        then:
        value == result

        where:
        sno | string    | result
        1   | "private" | com.intelli.linksharing.enums.Visibility.PRIVATE
        2   | "public"  | com.intelli.linksharing.enums.Visibility.PUBLIC
        3   | "dsdsd"   | com.intelli.linksharing.enums.Visibility.PUBLIC

    }

}