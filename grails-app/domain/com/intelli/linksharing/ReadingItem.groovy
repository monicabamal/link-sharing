package com.intelli.linksharing


class ReadingItem {
    Resource resource
    User user
    boolean isRead = Boolean.FALSE

    static belongsTo = [user: User, resource: Resource]


    static constraints = {
    }

    static namedQueries = {
        unRead{ User user->
            projections {
                property('resource')
            }

            eq('isRead',Boolean.FALSE)
            eq("user",user)

            //fetchMode('resource', FetchMode.L)
        }


    }
}
