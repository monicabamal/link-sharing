class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/article/$eventid"{
            controller="article"
            action="index"

        }

        "/"(controller:"home",action:"index")
        "500"(view:'/error')
        "/logout"(controller:"login",action:"logout")

    }
}
