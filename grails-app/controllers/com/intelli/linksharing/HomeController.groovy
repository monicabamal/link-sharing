package com.intelli.linksharing

class HomeController {

    def resourceService
    def userService
    def topicService

    def index() {
        if (session.username) {
            redirect controller: "home", action: "show", id: session.username
        } else {
            render view: "/home/home", model: [resources: resourceService.recentPublicResource(2, 0), topResources: resourceService.topRatedResource(2, 0)]
        }
    }

    def show() {
        println params.id
        UserCO user = userService.findUser(params.id)
        List<Topic> latestSubscribedTopics = userService.topUpdatedTopics(params.id)
        render view: "/user/dashboard", model: [user: user, readingItems: resourceService.unReadItem(2, 0, params.id), topics: topicService.subscribedTopic(5, 0, params.id)]
    }


    def testv() {
        render view: "/test", model: [topics: trendingTopic()]
    }

}
