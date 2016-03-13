package com.intelli.linksharing

import grails.transaction.Transactional
import org.springframework.http.HttpStatus

class LinkResourceController {

    def resourceService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LinkResource.list(params), model: [linkResourceInstanceCount: LinkResource.count()]
    }


    @Transactional
    def save(LinkResource linkResourceInstance) {

        linkResourceInstance.createdBy = User.findByUserName(session.username)

        linkResourceInstance = linkResourceInstance.save(flush: true)

        redirect controller: "documentResource", action: "show", id: linkResourceInstance.id

    }


    def markAsRead() {
        resourceService.markAsRead(session["username"], Long.parseLong(params.id))
    }

    def recentShares(){

        render template: '/resource/resource_list' ,
                bean: resourceService.recentPublicResource(Integer.parseInt(params.max), Integer.parseInt(params.offset)),
                var :'resources' ,
                model: [paginateController:'linkResource'
                        ,paginateAction:'recentShares',updateId:'recentShares',totalResource:10]
    }

    def topResources(){
        render template: '/resource/resource_list' ,
                bean: resourceService.topRatedResource(Integer.parseInt(params.max), Integer.parseInt(params.offset)),
                var :'resources' ,
                model: [paginateController:'linkResource'
                        ,paginateAction:'topResources',updateId:'topPosts',totalResource:10]


    }

    def inbox(){


        render template: '/resource/resource_list' ,
                bean: resourceService.unReadItem(Integer.parseInt(params.max), Integer.parseInt(params.offset),params.id),
                var :'resources' ,
                model: [paginateController:'linkResource'
                        ,paginateAction:'inbox',paginateId:params.id,updateId:'userInbox',totalResource:'10']


    }

    def trendingTopic(){
        println resourceService.topRatedResource(Integer.parseInt(params.max), Integer.parseInt(params.offset))
        render template: '/resource/resource_list' ,
                bean: resourceService.topRatedResource(Integer.parseInt(params.max), Integer.parseInt(params.offset)),
                var :'resources' ,
                model: [paginateController:'linkResource'
                        ,paginateAction:'trendingTopic',updateId:'trendingTopic',totalResource:'10']

    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkResource.label', default: 'LinkResource'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: HttpStatus.NOT_FOUND }
        }
    }

}
