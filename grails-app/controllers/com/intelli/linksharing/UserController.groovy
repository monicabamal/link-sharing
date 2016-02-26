package com.intelli.linksharing

class UserController {

    def index() {
        render "user dahsboard - ${session.user}"
    }

    def  register(){
        User user = new  User(firstName: '')
        if(!user.validate()){
             user.errors.allErrors.each {
                 println "${it.code}"
             }
        }
        else{
            render "success"
        }
    }
}
