package com.intelli.linksharing

import grails.test.mixin.TestFor
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

    void "test something"() {
        setup: "user created Resource"
        User user = new User(firstName: "monica", lastName: "bamal", email: "aef@b.com", password: "qwertdfy", username: "abc")
        Topic topic = new Topic(name:"grails", visibility:Topic.VisibilityType.PUBLIC, createdBy: user)
        LinkResource linkResource = new LinkResource(url: url,description:"this is helpfull" ,topic:topic ,createdBy:user )

        when: "check for validation"
        Boolean result = linkResource.validate()

        then: "test the result"
        result == valid

        where: "trying different values"

        sno | url                                                                 | valid
        1   | " "                                                                 | false
        2   | null                                                                | false
        3   | "http://grails.github.io/grails-doc/2.5.1/ref/Constraints/url.html" | true


    }
}

