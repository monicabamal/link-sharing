package com.intelli.linksharing

class LinkResource extends Resource{

    String url

    static constraints = {
        url url: true
    }

    @Override
    String toString(){
        url
    }
}
