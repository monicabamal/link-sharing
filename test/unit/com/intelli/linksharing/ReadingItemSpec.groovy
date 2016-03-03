package com.intelli.linksharing

import com.intelli.linksharing.enums.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@Mock([LinkResource])
class ReadingItemSpec extends Specification {

    def setup() {
    }


    def cleanup() {
    }

    void "test resource uniqueness per user"() {
        setup: "user rated resource"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        Topic topic = new Topic(name: "Java", visibility: Visibility.PUBLIC, createdBy: user)
        LinkResource linkResource = new LinkResource(url: "http://www.google.com",description:"Instrumentation API" ,topic:topic ,createdBy:user )
        ReadingItem readingItem= new ReadingItem(resource: linkResource, user: user, isRead:true)

        when:
        readingItem.save()

        then:
        ReadingItem.count() == 1

        when:
        ReadingItem readingItemNew= new ReadingItem(resource: linkResource, user: user, isRead:false)
        readingItemNew.save(flush: true)

        then:
        ReadingItem.count() == 1
        readingItemNew.errors.allErrors.size() == 1
        readingItemNew.errors.getFieldErrorCount('resource') == 1
    }
}
