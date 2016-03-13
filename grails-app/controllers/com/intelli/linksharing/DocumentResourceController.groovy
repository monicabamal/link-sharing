package com.intelli.linksharing

import grails.transaction.Transactional
import org.springframework.http.HttpStatus

class DocumentResourceController {

    def resourceService
    def topicService


    def show() {
        Resource resource = Resource.get(Long.parseLong(params.id))

        if (resource) {
            if(session["username"]) {
                resourceService.markAsRead(session["username"], Long.parseLong(params.id))
            }
            Topic topic=resource.topic
            render view: "/resource/resource", model: [resource: resource, topResources: resourceService.topRatedResource(2, 0), topics: topic, score: resourceService.getRating(session["username"], Long.parseLong(params.id)),subscribed: topicService.isSubscribed(session.username, topic.id)]

        } else {
            println("Check it")
        }
    }


    @Transactional
    def save(DocumentResourceCO documentResourceInstance) {
        //documentResourceInstance.topic=Topic.get(params.topic)

        documentResourceInstance.createdBy = User.findByUserName(session.username)

        DocumentResource documentResource = resourceService.addDocumentResource(documentResourceInstance)

        redirect controller: "documentResource", action: "show", id: documentResource.id
    }


    def getDocument(){

        DocumentResource documentResource=DocumentResource.get(Long.parseLong(params.id))
        File document = new File("${documentResource.filePath}")

        response.setContentType(documentResource.contentType)
        response.contentLength = document.bytes.length
        response.outputStream << document.bytes

    }



    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: HttpStatus.NOT_FOUND }
        }
    }
}
