package com.intelli.linksharing

class DocumentResource extends Resource {
    String filePath
    String  contentType

    static constraints = {
        filePath blank: false
        contentType blank : false
    }
}
