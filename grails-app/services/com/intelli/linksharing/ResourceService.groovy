package com.intelli.linksharing

import grails.transaction.Transactional

@Transactional
class ResourceService {

    def grailsApplication

    List<Resource> topRatedResource(int max, int offset){
        List list= ResourceRating.topRatedResource.list(max: max,offset : offset)
        return list*.getAt(0)
    }

    List<Resource> recentPublicResource(int max, int offset){
        return Resource.recentPublicResources.list(max: max, offset :offset)
    }
    List<Resource> unReadItem(int max, int offset, String userName){
        User user = User.findByUserName(userName)
        List list= ReadingItem.unRead(user).list(max: max,offset: offset)
        println(list)
        return list
    }

    DocumentResource addDocumentResource(DocumentResourceCO documentResourceCO){
        DocumentResource documentResource=documentResourceCO.properties as DocumentResource

        documentResource.filePath="${grailsApplication.config.filePath}/documents/${documentResourceCO.file.originalFilename}${new Date()}"
        documentResource.contentType=documentResourceCO.file.contentType
        File file = new File(documentResource.filePath)
        file.bytes = documentResourceCO.file.bytes

        return documentResource.save(flush: true)

    }

    void rateResource(Serializable resourceId,int score,String userName){
        Resource resource=Resource.get(resourceId)
        User user=User.findByUserName(userName)
        ResourceRating resourceRating=ResourceRating.findByUserAndResource(user,resource)

        if(resourceRating){
            resourceRating.score=score
        }
        else{
            resourceRating=new ResourceRating(user :user,resource: resource,score: score)
        }

        if(resourceRating.validate()){
            resourceRating.save(flush: true)
        }

    }

    int getRating(String userName,Serializable resourceId){
        ResourceRating resourceRating=ResourceRating.findByUserAndResource(User.findByUserName(userName),Resource.get(resourceId))

        if (resourceRating){
            return resourceRating.score
        }
        else
            return 0
    }

    void markAsRead(String userName,Serializable resourceId){
        ReadingItem readingItem=ReadingItem.findByUserAndResource(User.findByUserName(userName),Resource.get(resourceId))
        if(readingItem){
            readingItem.isRead=true
        }
        readingItem.save()
    }

    byte[] document(String name){

        File document = new File("${grailsApplication.config.filePath}/documents/${name}")
        if(document.exists()){
            return document.bytes
        }
        else {
            return
        }
    }

}
