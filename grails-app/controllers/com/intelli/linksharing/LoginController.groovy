package com.intelli.linksharing

class LoginController {

    def index() {
        if(session.user)
            forward(controller: 'user',action: 'index')
        else
            render "failure"
    }

    def loginHandler(String username, String password) {
        User user = User.findByFirstNameAndPassword(username, password)
        if(user){
            if(user.active){
                session.user = user
                redirect(action: 'index')
            }
            else
                flash.error 'Your account is not active'
        }
        else{
            flash.error = 'User not found'
        }
        render flash.error


    }

    def logout() {
        session.invalidate()
        forward(action: 'index')
    }
}
