package com.intelli.linksharing

import com.intelli.linksharing.co.ResourceSearchCO
import com.intelli.linksharing.enums.Visibility
import com.intelli.linksharing.enums.Seriousness

class TopicController {

    static scaffold = Topic

    static allowedMethods = [show: ['GET','POST'], save: ['GET','POST']]

    def show(ResourceSearchCO rco) {
        log.debug('Getting topic as read only so that changes will only be reflected when we will save the object')
        Topic topic = Topic.read(rco.topicId)
        if(!topic){
            flash.error = 'No topic exists in database'
            redirect(controller: 'login')
        }
        else if(topic.visibility == Visibility.PUBLIC){
            render 'Success'
        }
        else if(topic.visibility == Visibility.PRIVATE){
            if(Subscription.countByUserAndTopic(session.user, topic))
                render 'Success'
            else {
                flash.error = "${session.user.username} is not subscribed to topic - ${topic.name}"
                log.debug("${session.user.username} is not subscribed to topic - ${topic.name}")
                redirect(controller: 'login')
            }

        }
    }

    def save(Topic topic, String  seriousness){
            log.info("Saving topic with topic name - ${topic.name}")
            topic.createdBy = session.user
            topic.save(flush: true)
            if(topic.hasErrors()){
                log.error(topic.errors.allErrors)
                flash.error = "Error in saving topic. Please check logs for more info"
                render "Error in saving topic."
            }
            log.info('Topic saved successfully')
            flash.message = "Topic saved successfully."
            render "Success !!! "
    }
}
