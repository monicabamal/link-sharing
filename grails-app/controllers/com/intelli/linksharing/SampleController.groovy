package com.intelli.linksharing

class SampleController {

    static scaffold =  User

    static  defaultAction = "index"   // to set default action

    static allowedMethods = [myFirstAction: ['GET','POST']]
    def myFirstAction() {


        render "Hello"             //render on browser

        render(view: 'index')              //by default view will be of action name
    }
}
