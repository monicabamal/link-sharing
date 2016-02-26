package com.intelli.linksharing

class ApplicationFilters {

    def filters = {
        /*all(controller:'*', action:'*') {
            before = {
                log.info('Inside before filter')
            }
            after = { Map model ->
                log.info('inside after filter')
            }
            afterView = { Exception e ->
                log.info('Inside after view filter')
            }
        }
        loginCheck(controller: '*', controllerExclude: 'login'){
            before = {
                if(session.user){
                    redirect(controller: 'login')
                }
            }

        }*/
    }
}
