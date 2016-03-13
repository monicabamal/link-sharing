package com.intelli.linksharing

import org.springframework.http.HttpStatus

class ResourceRatingController {

    def resourceService


    def rateResource() {
        resourceService.rateResource(Long.parseLong(params.id), Integer.parseInt(params.score), session.username)
        render ""
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'resourceRating.label', default: 'ResourceRating'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: HttpStatus.NOT_FOUND }
        }
    }
}
