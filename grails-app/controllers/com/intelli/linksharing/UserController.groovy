package com.intelli.linksharing

class UserController {

    static  allowedMethods = [index: 'GET']

    def index() {
        log.info('Inside UserController index action' )
        render "user dahsboard - ${session.user}"
    }

}
