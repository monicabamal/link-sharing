import com.intelli.linksharing.DocumentResource
import com.intelli.linksharing.LinkResource
import com.intelli.linksharing.ReadingItem
import com.intelli.linksharing.Resource
import com.intelli.linksharing.Seriousness
import com.intelli.linksharing.Subscription
import com.intelli.linksharing.Topic
import com.intelli.linksharing.User
import com.intelli.linksharing.Visibility

class BootStrap {

    def bootstrapService

    def init = { servletContext ->
        bootstrapService.createUsers()
        bootstrapService.createTopic()
        bootstrapService.createResource()
        bootstrapService.createSubscription()
        bootstrapService.readItem()
        bootstrapService.rateResource()

    }
    def destroy = {
    }


}
