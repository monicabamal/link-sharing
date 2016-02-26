package com.intelli.linksharing

class ApplicationFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                log.info('Inside before action filter')
            }
            after = { Map model ->
                log.info('Inside after action filter')
            }
            afterView = { Exception e ->
                log.info('Inside after view filter')
            }
        }
        loginCheck(controller: '*', controllerExclude: 'login'){
            before = {
                log.info('Inside Login Check filter')
                if(!session.user){
                    log.info('User is not logged in')
                    redirect(controller: 'login')
                }
            }

        }
    }
}
