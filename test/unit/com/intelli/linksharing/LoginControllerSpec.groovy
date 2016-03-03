package com.intelli.linksharing

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoginController)
@Mock(User)
class LoginControllerSpec extends Specification {


    LoginController loginController

    def setup() {
        loginController = new LoginController();
    }

    def cleanup() {
    }

    @IgnoreRest
    void "test login action"() {

        setup:"stubbing user to check user exists or not"
        User.findByUsernameAndPassword("monica","igdefault") >> new User(active: true)

        when:
        loginController.loginHandler(username,password)

        then:
        response.redirectedUrl == redirectUrl
        response.forwardedUrl == forwardUrl
        flash.error == error


        where:
        sno|username|password|redirectUrl|forwardUrl|error
        1  |"monica"|"igdefault"|"/login/index"|null|null
      //  2  | "monica1"    |"igdefault"|null|"/user/index"|null
      //  3  | "sdfsdf"    |"dewdes"   |null|null|'User not found'

    }


    void "test index action"() {

       /* when:
        loginController.index()

        then:
        response.text == "failure"*/

      /*  when:
        session.user = new User()
        loginController.index()

        then:
        response.forwardedUrl = '/user/index'*/

    }

}
