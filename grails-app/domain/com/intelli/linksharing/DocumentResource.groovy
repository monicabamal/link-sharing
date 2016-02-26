package com.intelli.linksharing

class DocumentResource extends Resource {

    String filepath

    static constraints = {
        filepath blank: false
    }

}
