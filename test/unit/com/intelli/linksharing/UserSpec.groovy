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


    def "Check email and user uniqueness"() {
        given: "User Object"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");

        when: "User will save"
        user.save(flush: true);

        then: "check no. of records saved"
        user.count() == 1;

        when: ""
        user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
            user.save(flush: true);

        then:
        user.count() == 1;
        user.errors.allErrors != null
        user.errors.getFieldErrorCount('email') == 1;
        user.errors.getFieldErrorCount('username') == 1;

    }

    def "checking all fields"() {

        given: "Create object"
        User user = new User(email: email,userName: userName,password: password, firstName: firstName, lastName: lastName)

        when:
        boolean result = user.validate()
        then:
        result == validate

        where:
         sno|  password |   userName    |firstName| lastName |    email      | validate
          1 |"igdefault"|"Monica Bamal" |"Monica" | "Bamal"  |     ""        | false
          2 |"igdefault"|"Monica Bamal" |"Monica" | "Bamal"  |    null       | false
          3 |"igdefault"|"Monica Bamal" |"Monica" | "Bamal"  |"invalid email"| false
          4 |"igdefault"|    null       |"Monica" | "Bamal"  |"abc@gmail.com"| false
          5 |""         |"Monica Bamal" |"Monica" | "Bamal"  |"abc@gmail.com"| false
          6 |null       |"Monica Bamal" |"Monica" | "Bamal"  |"abc@gmail.com"| false
          7 |"min2"     |"Monica Bamal" |"Monica" | "Bamal"  |"abc@gmail.com"| false
          8 |"igdefault"|"Monica Bamal" |  ""     | "Bamal"  |"abc@gmail.com"| false
          9 |"igdefault"|"Monica Bamal" |  null   | "Bamal"  |"abc@gmail.com"| false
         10 |"igdefault"|"Monica Bamal" |"Monica" |   ""     |"abc@gmail.com"| false
         11 |"igdefault"|"Monica Bamal" |"Monica" |   null   |"abc@gmail.com"| false

    }

    def "test transient field getName"() {

        given: "User Object"
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: firstname,lastName: lastname);

        when: "access transient field"
        String name = user.name

        then: ""
        name == result

        where:
        sno|firstname|lastname |result
         1 | "Monica"| "Bamal" |"Monica Bamal"
         2 | "Vikram"|"Chandel"|"Vikram Chandel"

    }

    def "check toString method"(){

        given:
        User user = new User(email: "abc@gmail.com",username: username, password: "igdefault",firstName: "monica",lastName: "bamal");

        expect:
        user.toString() == result

        where:
        sno|    username    |  result
         1 | "monica bamal" |"monica bamal"
         2 | "monica1 bamal"|"monica1 bamal"


    }

}

