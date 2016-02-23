package com.intelli.linksharing

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    def "Check #email_id"() {
        given: "User Object"
        User user = new User(email_id: "abc@gmail.com", password: "defger",firstName: "monica",lastName: "bamal");

        when: "User will save"
        user.save(flush: true);

        then: ""
        user.count() == 1;

        when: ""
        user = new User(email_id: "ffgtrg", firstName: "monica", lastName: "bamal", password: "deefref", userName: "jsnaj");
        user.save(flush: true);

        then:
        user.count() == 1;
        user.errors.allErrors.size() == 1;
        user.errors.getFieldErrorCount('email_id') == 1;

    }

    def "checking all fields with #password"() {

        given: "Create object"
        User user = new User(password: password, userName: userName, firstName: firstName, lastName: lastName, email_id: email_id)

        when:
        user.save(flush: true)
        boolean result = user.validate()
        then:
        result == validate

        where:
        password | userName      | firstName | lastName | email_id     | validate
        "s"      | "Monica Bamal" | "Monica"   | "Bamal"  | "abc@s.com" | false
        "s"      | "Monica Bamal" | "Monica"   | "Bamal"  | "dsdj "      | false
        "swer"   | "Monica Bamal" | "Monica"   | "Bamal"  | "sad@s.com" | false
        "swerew" | "Monica Bamal" | "Monica"   | "Bamal"  | "sdaf@s.com" | true
    }

}

