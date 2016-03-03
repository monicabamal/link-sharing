package com.intelli.linksharing.enums

/**
 * Created by ttnd on 23/2/16.
 */
enum Visibility {

    PUBLIC,
    PRIVATE

    static toEnum(String string){
        if(string.equalsIgnoreCase("private"))
            this.PRIVATE
        else
            this.PUBLIC
    }
 }