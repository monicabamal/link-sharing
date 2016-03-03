package com.intelli.linksharing

import com.intelli.linksharing.enums.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@Mock([LinkResource])
class ResourceRatingSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test rating by user"() {

        setup: "user giving rating to resource"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        Topic topic = new Topic(name: "Java", visibility: Visibility.PUBLIC, createdBy: user)
        LinkResource linkResource = new LinkResource(url: 'http://www.google.com',description:"Instrumentation API" ,topic:topic ,createdBy:user )
        ResourceRating resourceRating = new ResourceRating(resource: linkResource, user: user, score: value)

        when: "check for validation"
        Boolean result = resourceRating.validate()

        then: "test the result"
        result == valid

        where: "trying different values"
        sno|value|valid
        1  |0    |false
        2  |7    |false
        3  |4    |true


    }

    void "user unique resource "() {

        setup: "user rated resource"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        Topic topic = new Topic(name: "Java", visibility: Visibility.PUBLIC, createdBy: user)
        LinkResource linkResource = new LinkResource(url: 'http://www.google.com',description:"Instrumentation API" ,topic:topic ,createdBy:user )
        ResourceRating resourceRating = new ResourceRating(resource: linkResource, user: user, score: 5)

        when:
        resourceRating.save(flush: true)

        then:
        ResourceRating.count() == 1

        when:
        ResourceRating resourceRatingNew = new ResourceRating(resource: linkResource, user: user, score: 3)
        resourceRatingNew.save(flush: true)

        then:
        ResourceRating.count() == 1
        resourceRatingNew.errors.allErrors.size() == 1
        resourceRatingNew.errors.getFieldErrorCount('resource') == 1


    }
}