package com.intelli.linksharing

class LoginController {

    def login(String userName) {
        println("done ${userName} ")
        User user = User.findByUserNameAndPassword(userName, params.password)
        if (user != null) {

            redirect(controller: 'user', action: 'loginHandler', id: userName, params: [admin: user.admin])
        } else {
            render(view: "/login/index", model: [msg: "Wrong username or password"])
        }


    }

    def logout() {
        session.invalidate()
        redirect(controller: 'home', action: 'index')

    }
}
