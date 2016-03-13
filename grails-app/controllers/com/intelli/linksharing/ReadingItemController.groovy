package com.intelli.linksharing

import org.springframework.http.HttpStatus

class ReadingItemController {
    def mailService

    def scaffold = true

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def showReadingItem() {
        User user = User.get(params.id)
        List<ReadingItem> readingItems = ReadingItem.unReadForUser(user).list(max: 2, offset: 0)
        List<Topic> topics = Topic.topSubscription(user).list(max: 5, offset: 0)

        render topics


    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: HttpStatus.NOT_FOUND }
        }
    }


}
