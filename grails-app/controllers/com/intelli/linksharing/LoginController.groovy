package com.intelli.linksharing

class LoginController {

    static  allowedMethods = [index: 'GET', loginHandler: ['GET','POST'], loginHandler: ['GET']]

    def index() {
        log.info('Checking whether user is already logged in or not')
        if(session.user){
            log.debug('user is already logged in')
            forward(controller: 'user',action: 'index')
        }
        else{
            log.debug('User is not logged in')
            render "failure"
        }

    }

    def loginHandler(String username, String password) {
        log.info("Checking user with username - ${username} exists or not")
        User user = User.findByUsernameAndPassword(username, password)
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

    def  register(User user){
        log.info("Registering user - ${user}")
        if(!user){
            flash.message = 'User is not set'
            render "${user.errors.allErrors.collect{message(error: it).join(',') }}"
        }else{
            if(!user.validate()){
                render  view: "/login/index", model:[user: user]
            }else
                render 'Success'
        }
    }
}
