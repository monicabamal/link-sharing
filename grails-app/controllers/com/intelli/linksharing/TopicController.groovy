package com.intelli.linksharing

import grails.transaction.Transactional
import org.springframework.http.HttpStatus

class TopicController {

    def topicService
    def linksharingMailService


    def show() {
        try {
            TopicCO topic = topicService.findTopic(Integer.parseInt(params.id))
            if (params.invitaion || topic.visibility == Visibility.PUBLIC || topic.createdBy.userName == session["username"]) {
                render view: "/topic/topics", model: [topic: topic, topics: topic, resources: topic.resource, subscribed: topicService.isSubscribed(session.username, (params.id as Long))]
            } else {
                render "Topic not found"
            }
        }
        catch (Exception e){
            render "Topic not found"

        }
    }


    @Transactional
    def save(Topic topicInstance) {
        topicInstance.createdBy = User.findByUserName(session.username)
        topicInstance.save(flush: true)
        redirect controller: "home", action: "show", id: session.username
    }


    def topics() {
        def topicInstastanceList = Topic.findAllByVisibility(Visibility.PUBLIC)


        render view: "topics", model: [topicInstanceList: topicInstastanceList, topicInstanceCount: topicInstastanceList.size()]
    }

    def searchTopic() {

        println params

        render template: "/topic/topic_list", bean: topicService.searchTopic(params.search), var: "topics"
    }


    def sendInvitation() {
        String token = topicService.generateInvitation(params.to, Long.parseLong(params.topic))
        println(token)
        String to = params.to
        String body = linksharingMailService.generateInvitationBody(token,Long.parseLong(params.topic))
        MailCO mailCO = new MailCO(to: [to], body: body, subject: "Invitation to Topic")
        linksharingMailService.sendMail(mailCO)
        render "Mail Sent"
    }


    def showInvitation() {
        Invitation invitation = Invitation.findByInvitationToken(params.id)
        redirect controller: "topic", action: "show", id: invitation.topic.id, model: [invitaion: invitation]
    }

    def subscribe() {
        topicService.subscribe(session.username, Long.parseLong(params.id))
        render template: "/topic/unsubscribe", bean: params.id, var: "id"
    }

    def unSubscribe() {
        topicService.unSubscribe(session.username, Long.parseLong(params.id))
        render template: "/topic/subscribe", bean: params.id, var: "id"
    }

    def changeSeriousness() {
        topicService.changeSeriousness(session.username, Long.parseLong(params.id), params.seriousness)
        render params.seriousness
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'topic.label', default: 'Topic'), params.id])
                redirect action: "index", method: "GET"
            } list
            '*' { render status: HttpStatus.NOT_FOUND }
        }
    }
}
