import com.intelli.linksharing.User
import groovy.LonkSharingConstants

class BootStrap {

    def grailsApplication



    def init = { servletContext ->
        println  "External file property -->> "+grailsApplication.config.project

        /*

        List<User> users

        createUser(){
            try{
                if(!User.findByActive(true)) {
                    new User(email: 'admin@gmail.com', password: LonkSharingConstants.DEFAULT_PASSWORD, firstName: 'monica', lastName: 'bamal',
                            photo: 'photo1.png', admin: true, active: true).save(failOnError: true, flush: true)
                    log.info('1 admin is created')
                }
                if(User.findByActive(false)){
                    new User(email: 'normal@gmail.com', password: LonkSharingConstants.DEFAULT_PASSWORD, firstName: 'monica', lastName: 'bamal',
                            photo: 'photo1.png', admin: false, active: true ).save(failOnError: true,flush: true)
                    log.info('1 normal user is created')
                }

            }catch (Exception ex){
                log.error(ex.getMessage())
            }



        }
        */

    }
    def destroy = {
    }
}
