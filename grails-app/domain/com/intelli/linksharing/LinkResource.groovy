package com.intelli.linksharing

class LinkResource extends Resource {
    String url

    static constraints = {
        url blank: false, url: true

    }

}
