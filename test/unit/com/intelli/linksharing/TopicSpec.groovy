package com.intelli.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

import java.beans.Visibility

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    def "test something"() {
        given: ""
        String topicName = "Grails";


        user = new User(email_id: email_id, firstName: "monica", lastName: "bamal", password: "deefref", userName: "jsnaj");
        Topic topic = new Topic(name: topicName, createdBy: user, visibility: Topic.VisibilityType.PUBLIC);
        when: "User will save"
        topic.save();

        then: ""
        topic.count() == 1;

        when: ""
        Topic newTopic = new Topic(name: topicName, createdBy: user, visibility: Topic.VisibilityType.PUBLIC);
        newTopic.save();

        then:
        topic.count() == 1;
        newTopic.errors.allErrors.size() == 1;
        newTopic.errors.getFieldErrorCount('name') == 1;


    }

    def "Visibility should not be null & must be enum"() {
        setup: "user created topic"
        Topic topic = new Topic(name: name, visibility: Topic.VisibilityType.PUBLIC)

        when: "check for valiation"
        Boolean result = topic.validate()

        then: "test the result"
        result == valid

        where: "trying different values"

        sno | name     | visibility | valid
        1   | "grails" | " "        | false
        2   | "java"   | null       | false
        3   | "grails" | "PUBLIC"   | true
        4   | "grails" | "PRIVATE"  | true
        5   | "grails" | "xyz"      | false

    }
}