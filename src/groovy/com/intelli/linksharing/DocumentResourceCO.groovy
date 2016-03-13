package com.intelli.linksharing

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile


@Validateable
class DocumentResourceCO extends ResourceCO {
    String filePath
    String  contentType
    MultipartFile file

    static constraints = {
        filePath blank: false
        contentType blank : false
    }
}
