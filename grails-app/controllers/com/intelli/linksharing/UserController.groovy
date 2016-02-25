package com.intelli.linksharing

class UserController {

    def index() {
        render "user dahsboard - $session.user"

    }

    def  register(){
        if(session.user){

        }
        else{
            render "success"
        }
    }
}
