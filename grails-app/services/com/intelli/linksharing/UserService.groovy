package com.intelli.linksharing

import grails.transaction.Transactional

@Transactional
class UserService {
def grailsApplication
    Boolean save(UserCO userCO) {
        User user = userCO.properties as User
        if(user.photo.length>0) {
            File ph = new File("${grailsApplication.config.filePath}/profilePic/${user.userName}")
            ph.bytes = user.photo
        }
        user.photo = null
        user.save(flush: true)
    }

    UserCO findUser(String userName) {
        User userInstance = User.findByUserName(userName)
        UserCO user = new UserCO(userInstance.properties)


        return user
    }

    byte[] photo(String userName) {
        File ph = new File("${grailsApplication.config.filePath}/profilePic/${userName}")
        if(ph.exists()){
            return ph.bytes
        }
        else {
            println(grailsApplication.config.filePath)
            return new File("${grailsApplication.config.filePath}/profilePic/profile.jpg").bytes
        }

    }

    List<Topic> topUpdatedTopics(String userName) {

        return Topic.topUpdatedTopics(User.findByUserName(userName)).list(max: 5, offset: 0)
    }

    def serviceMethod() {

    }

    User deactivate(String userName){
        User user=User.findByUserName(userName)
        if(user){
            user.active=false
            user.save()
        }
        user
    }

    User activate(String userName){
        User user=User.findByUserName(userName)
        if(user){
            user.active=true
            user.save()
        }
        user
    }
    boolean validateUserName(String userName){
        if(User.findByUserName(userName)){
            return false
        }
        else {
            return true
        }
    }

    boolean validateEmail(String email){
        if(User.findByEmail(email)){
            return false
        }
        else {
            return true
        }
    }


    Boolean update(UserCO userCO) {
        User user=User.findByUserName(userCO.userName)

        if(userCO.photo.size()>0) {
            File ph = new File("${user.userName}")
            ph.bytes = userCO.photo
            userCO.photo = null
        }
        //.bindData(user, userCO, [include: ['firstName', 'lastName']])
        user.firstName=userCO.firstName
        user.lastName=userCO.lastName
        user.save()
    }


    boolean changePassword(UserCO userCO){
        User user=User.findByUserName(userCO.userName)
        if(userCO.password==userCO.rePassword){
            user.password=userCO.password
        }
        user.save()
    }

}
