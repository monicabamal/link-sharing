package com.intelli.linksharing

import grails.transaction.Transactional

@Transactional
class TopicService {
    def grailsApplication

    TopicCO findTopic(Integer id) {
        Topic topicInstance = Topic.get(id)

        def par = topicInstance.properties['id','name', 'createdBy', 'dateCreated', 'lastUpdated', 'visibility', 'subscription', 'resource']
        TopicCO topic = new TopicCO(par)

        return topic
    }

    List<Topic> subscribedTopic(int max, int offset, String userName){

        User user=User.findByUserName(userName)
        println("${max}.........${offset}")
        return Subscription.subscribedTopics(user).list(max:max,offset:offset)
    }

    List<Topic> searchTopic(String key){

        return Topic.searchTopic(key).list()
    }


    void subscribe(String userName,Long topicId){
        new Subscription(user: User.findByUserName(userName),topic: Topic.get(topicId)).save(flush: true)
    }

    void unSubscribe(String userName,Long topicId){
        println("${userName}${topicId}")
        Subscription.findByUserAndTopic(User.findByUserName(userName),Topic.get(topicId)).delete(flush: true)

    }
    boolean isSubscribed(String userName, Serializable topicId){
        Subscription subscription=Subscription.findByUserAndTopic(User.findByUserName(userName),Topic.get(topicId))
        if (subscription){
            return true
        }
        else{
            return false
        }
    }

    void changeSeriousness(String userName,Serializable topicID,String seriousness){
        Subscription subscription=Subscription.findByUserAndTopic(User.findByUserName(userName),Topic.get(topicID))
        subscription.seriousness=seriousness
        subscription.save()
    }


    String generateInvitation(String email,Serializable topicId){
        String token=email+topicId
        Invitation invitation=Invitation.findByInvitationToken(token)
        if(!invitation) {
            invitation = new Invitation(toEmail: email, topic: Topic.get(topicId), invitationToken: token)
            invitation.save(flush: true)
        }
        println(invitation)
        return token
    }


}
