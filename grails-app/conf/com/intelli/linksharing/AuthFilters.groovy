package com.intelli.linksharing

class AuthFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                println servletContext.getRealPath("/")
                log.info "Params : ${params} :: User : $session.username"
            }
        }

        authFilter(controller: '*', action: '*', actionExclude: 'validateUserName|validateEmail|show|profilePhoto|searchTopic|recentShares|topResources|trendingTopic|loginHandler|showInvitation', controllerExclude: 'login|assets|home|user') {
            before = {
                println("done")

                if (!session.username) {

                    redirect(controller: 'home', action: 'index')
                    println("inside ${session.getAttribute("username")}")
                }
            }


            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }


    }
}
