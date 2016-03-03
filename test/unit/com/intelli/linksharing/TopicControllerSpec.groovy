package com.intelli.linksharing

import com.intelli.linksharing.enums.Visibility
import com.intelli.linksharing.enums.Seriousness
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TopicController)
class TopicControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @IgnoreRest
    void "test topic save"() {
        User user = new User(email: "abc@gmail.com", username: "monicabamal", password: "igdefault", firstName: "monica", lastName: "bamal");
        Topic topic = new Topic(name: topicName, createdBy: user, visibility: Visibility.PUBLIC);
        TopicController topicController = new TopicController()

        when: "Topic will save"
        topicController.save(topic, Seriousness.VERY_SERIOUS)

        then: "check whether topic is saved or not"
        flash.message == message
        flash.error == error
        response.text == text

        where:
        sno|topicName|            message        |                         error                          |text
         1 |"topic1" |"Topic saved successfully."|                         null                           |"Success !!! "
         2 |"topic1" |null                       |"Error in saving topic. Please check logs for more info"|"Error in saving topic."

    }
}
