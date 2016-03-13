package com.intelli.linksharing

import org.springframework.http.HttpStatus

class UserController {

    def userService

    def beforeInterceptor = [action: this.&isAdmin, only: 'list']

    def isAdmin() {
        if (!session.admin) {
            redirect(controller: "user", action: "show", params: [id: session.username])

        }

    }


    def show() {
        UserCO user = userService.findUser(params.id)
        List<Topic> latestSubscribedTopics = userService.topUpdatedTopics(params.id)
        render view: "dashboard", model: [user: user, readingItems: user.readingItem, topics: latestSubscribedTopics]
    }


    def save(UserCO userInstance) {


        userService.save(userInstance)
        redirect action: "show", params: [id: userInstance.userName]

    }


    def list() {
        render view: "/user/users", model: [users: User.list(max: 20, offset: 0)]
    }

    def loginHandler() {

        session.setAttribute("username", params.id)
        session.setAttribute("name", params.id)
        if (params.admin == "true") {
            session.setAttribute("admin", params.admin)
        }

        redirect controller: "home", action: "show", params: [id: params.id]

    }

    def profilePhoto() {
        byte[] photo = userService.photo(params.id)

        response.setContentType("image/jpg")
        response.contentLength = photo.length
        response.outputStream << photo


    }

    def deactivate() {
        User user = userService.deactivate(params.id)
        if (user) {
            render template: "/user/user_table_item", bean: user, var: "user"
        }
    }


    def activate() {
        User user = userService.activate(params.id)
        if (user) {
            render template: "/user/user_table_item", bean: user, var: "user"
        }
    }

    def validateUserName() {

        render userService.validateUserName(params.userName)
    }

    def validateEmail() {

        render userService.validateEmail(params.email)
    }

    def edit() {
        render view: "/user/edit_profile", model: [user: userService.findUser(session["username"])]
    }

    def update(UserCO userCO) {
        userService.update(userCO)

    }

    def changePassword(UserCO userCO) {
        userService.changePassword(userCO)

    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: HttpStatus.NOT_FOUND }
        }
    }


}

