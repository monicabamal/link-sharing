package com.intelli.linksharing

class TopicController {

    def show(int id) {
        Topic topic = Topic.findById(id)
        if(topic){
            flash.error = 'No topic exists in database'
            redirect(controller: 'login')
        }
        else if(topic.visibility == enums.Visibility.PUBLIC){
            render 'Success'
        }
        else if(topic.visibility == enums.Visibility.PRIVATE){
            Subscription subscription = Subscription.findByUserAndTopic(session.user, topic)
            if(subscription)
                render 'Success'
            else {
                flash.error = 'No suscription found'
                redirect(controller: 'login')
            }

        }
    }
}
