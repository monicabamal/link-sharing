package com.intelli.linksharing

class UserController {

    def index() {
        //render "user dahsboard - $session.user"
    //    User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName:null,lastName: "bamal");
    //    user.save(flush: true)
    //    println user.errors.hasFieldErrors("firstName")
        render(view: "index" )

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
