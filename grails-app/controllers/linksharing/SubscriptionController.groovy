package linksharing

import com.intelli.linksharing.Subscription
import com.intelli.linksharing.Topic
import com.intelli.linksharing.enums.Seriousness

class SubscriptionController {

    static scaffold = Subscription

    static allowedMethods = [index: 'GET', save: 'GET', update: ['GET','POST']]

    def index() {
        //dafault action
    }

    def delete(Long id){
        log.info("Inside subscription delete action")
        Subscription subscription = Subscription.get(id)
        if(!subscription) {
            log.error("No subscription found with id - ${id} for topic - ${subscription.topic.name}")
            render "User is not subscribed to topic - ${subscription.topic.name}"
        }else{
            log.info("User unsubscribed successfully for topic - ${subscription.topic.name}")
            subscription.delete()
            render "Success !!!"
        }
    }

    def save(Long id){
        Topic topic = Topic.get(id)
        Subscription subscription = new Subscription(topic: topic, user: session.user)
        log.info("Subscribing to topic - ${topic.name}")
        subscription.save(failOnError: false)
        if(subscription.errors.hasErrors()) {
            log.error(subscription.errors.allErrors)
            render subscription.errors.allErrors
        }else {
            log.info("User subscribed topic - ${topic.name} successfully")
            render "Success !!! "
        }
    }

    def update(Long id, String seriousness){
        Subscription subscription = Subscription.findByIdAndSeriousness(id, Seriousness.toEnum(seriousness))
        if(subscription){
            log.info('Updating subscription .. ')
            subscription.save()
            if(subscription.errors.hasErrors()) {
                log.error(subscription.errors.allErrors)
                render subscription.errors.allErrors
            }else {
                log.info("Subscription updated for topic - ${subscription.topic.name}")
                render "Success !!! "

            }
        }else {
            log.error('No subscription found')
            render "not found"
        }

    }
}
