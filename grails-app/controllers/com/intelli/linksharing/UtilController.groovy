package com.intelli.linksharing

class UtilController{

    def index(String name) {
        log.debug('Inside UtilController')
        try{
            params.each {
                log.info("${it.key} = ${it.value}")
            }
            10/0
        }
        catch (Exception ex) {
            log.error('Divide by zero exception')
        }
        log.info('UtilController executed successfully');
    }
}