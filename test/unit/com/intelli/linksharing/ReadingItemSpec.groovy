package com.intelli.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {

    def setup() {
    }


    def cleanup() {
    }

    void "test something"() {
        setup: "user rated resource"
        User user = new User(firstName: "monica", lastName: "bamal", email: "daf@b.com", password: "qwerty", username: "abc")
        LinkResource linkResource = new LinkResource(description: " this is helpfull", createdBy: user, topic:"grails", url: "http://grails.github.io/grails-doc/2.5.1/ref/Constraints/url.html")
        ReadingItem readingItem= new ReadingItem(resources: linkResource, user: user, isRead:true)

        when:
        readingItem.save()

        then:
        readingItem.count() == 1

        when:
        ReadingItem readingItemNew= new ReadingItem(resources: linkResource, user: user, isRead:true)
        readingItemNew.save()

        then:
        readingItem.count() == 1
        readingItemNew.errors.allErrors.size() == 1
        readingItemNew.errors.getFieldErrorCount('resources') == 1
    }
}
