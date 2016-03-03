package linksharing

import com.intelli.linksharing.Resource
import com.intelli.linksharing.Topic
import com.intelli.linksharing.co.ResourceSearchCO
import com.intelli.linksharing.enums.Visibility

class ResourceController {

    def index() { }

    def search(ResourceSearchCO rco){
        if(rco.q){
            rco.visibility = Visibility.PUBLIC
            List<Resource> resources = Resource.search(rco)
        }

    }

    def delete(long id){
        log.info("Load resource with id - ${id}")
        Resource resource = Resource.load(id)
        try{
            resource.delete()
            log.info ("resource deleted successfully")
            render "resource deleted successfully"
        }
        catch (Exception ex){
            log.error("No resource found for resource id = ${id}")
            render "No resource found for resource id = ${id}"
        }

    }

    def show(){
        Resource.ratingInfo
        Topic.getTrendingTopics()
    }
}
