package com.intelli.linksharing

class LinkResource extends Resource{

    String url

    static constraints = {
        url url: true
    }

    String toString(){
        url
    }
}
