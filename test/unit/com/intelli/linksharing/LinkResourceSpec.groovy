package com.intelli.linksharing

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LinkResource)
class LinkResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "validate link resource URL"() {
        setup: "user created Resource"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        Topic topic = new Topic(name: "Java", visibility: enums.Visibility.PUBLIC, createdBy: user)
        LinkResource linkResource = new LinkResource(url: url,description:"Instrumentation API" ,topic:topic ,createdBy:user )

        when: "check for validation"
        Boolean result = linkResource.validate()

        then: "test the result"
        result == valid

        where: "trying different values"

        sno |url                                                                 |valid
        1   |" "                                                                 |false
        2   |null                                                                |false
        3   |"http://grails.github.io/grails-doc/2.5.1/ref/Constraints/url.html" |true
        4   |"dscsdfsdvf"                                                        |false


    }

    def "check toString method"(){

        given:
        LinkResource linkResource = new LinkResource(url: url);

        expect:
        linkResource.toString() == result

        where:
        sno|            url           |        result
         1 | "http://www.google.com"  |"http://www.google.com"
         2 | "http://www.facebook.com"|"http://www.facebook.com"


    }

}

