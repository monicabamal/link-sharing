package com.intelli.linksharing

import enums.Visibility
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test filepath of resource"() {
        setup: "user added resourse document"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        Topic topic = new Topic(name: "Java", visibility: enums.Visibility.PUBLIC, createdBy: user)
        DocumentResource documentResource = new DocumentResource(filePath: filepath, description: "topic description", topic: topic, createdBy: user)

        when: "check for validation"
        Boolean result = documentResource.validate()

        then: "test the result"
        result == valid

        where: "trying different values"

        sno | filepath     | valid
        1   | " "          | false
        2   | null         | false
        3   | "/home/ttnd" | true


    }


    def "check toString method"(){

        given:
        DocumentResource documentResource = new DocumentResource(filepath: filepath);

        expect:
        documentResource.toString() != result

        where:
        sno|   filepath  |       result
         1 | "/home/ttnd"|"http://www.google.com"
         2 | "a/b/c/d"   |"http://www.facebook.com"


    }
}