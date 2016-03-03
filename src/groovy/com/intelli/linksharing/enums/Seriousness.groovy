package com.intelli.linksharing.enums

/**
 * Created by ttnd on 23/2/16.
 */
enum Seriousness {

    SERIOUS,
    VERY_SERIOUS,
    CASUAL

    static toEnum(String seriousness){
        if(seriousness.equalsIgnoreCase('Serious'))
            return this.SERIOUS
        else if(seriousness.equalsIgnoreCase('very_serious'))
            return this.VERY_SERIOUS
        else
            this.CASUAL

    }

}