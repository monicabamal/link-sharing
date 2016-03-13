package com.intelli.linksharing

import grails.gsp.PageRenderer
import grails.transaction.Transactional

@Transactional
class LinksharingMailService {

    def mailService
    def grailsApplication
    PageRenderer groovyPageRenderer

    def sendMail(MailCO mail){


        mailService.sendMail{
            multipart true
            to mail.to.toArray()
            subject mail.subject
            html mail.body
            attachBytes 'linksharing.png','image/png', new File("${grailsApplication.config.filePath}/linksharing.png").readBytes()
        }

    }
    def generateInvitationBody(String token,Serializable topicID){
        groovyPageRenderer.render(view: '/topic/Invitation',model: [topic:Topic.get(topicID), invitationText: "Invitation to topic is ${grailsApplication.config.grails.serverURL}/topic/showInvitation?id=${token}"])

    }

    Map weeklyMailSubscriber(){
        List list=Subscription.seriousEmployee.list()

        return list.groupBy ({ item -> item[0] })

    }

    Map monthlyMailSubscriber(){
        List list=Subscription.verySeriousEmployee.list()

        return list.groupBy ({ item -> item[0] })

    }
}
