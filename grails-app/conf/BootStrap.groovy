import com.intelli.linksharing.Topic
import com.intelli.linksharing.User
import groovy.LonkSharingConstants

class BootStrap {

    def grailsApplication



    def init = { servletContext ->
        println  "External file property -->> "+grailsApplication.config.project



        List<User> users

        createUser(){
            try{
                if(User.count) {
                    User admin = new User(email: 'admin@gmail.com', password: LonkSharingConstants.DEFAULT_PASSWORD, firstName: 'monica', lastName: 'bamal',
                             userName: 'monicabamal', admin: true, active: true)
                    admin..save(failOnError: true, flush: true)
                    log.info('1 admin is created')

                    User normalUser = new User(email: 'normal@gmail.com', password: LonkSharingConstants.DEFAULT_PASSWORD, firstName: 'monica1', lastName: 'bamal1',
                             userName: 'monicabamal1', admin: false, active: true )
                    normalUser..save(failOnError: true,flush: true)
                    log.info('1 normal user is created')
                }

            }catch (Exception ex){
                log.error("Error during creating users - "+ex.getMessage())
            }
        }

        createTopics(){
            if(Topic.count){
                
            }
        }



    }
    def destroy = {
    }
}
