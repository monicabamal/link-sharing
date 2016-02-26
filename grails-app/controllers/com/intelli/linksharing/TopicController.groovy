package com.intelli.linksharing

class TopicController {

    def show(int id) {
        Topic topic = Topic.findById(id)
        if(!topic){
            flash.error = 'No topic exists in database'
            redirect(controller: 'login')
        }
        else if(topic.visibility == enums.Visibility.PUBLIC){
            render 'Success'
        }
        else if(topic.visibility == enums.Visibility.PRIVATE){
            if(Subscription.countByUserAndTopic(session.user, topic))
                render 'Success'
            else {
                flash.error = "${session.user.username} is not subscribed to topic - ${topic.name}"
                redirect(controller: 'login')
            }

        }
    }
}
