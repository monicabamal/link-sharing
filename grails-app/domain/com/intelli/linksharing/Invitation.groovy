package com.intelli.linksharing


class Invitation {
    String toEmail
    String invitationToken

    static belongsTo = [topic : Topic]

    static constraints = {
        toEmail unique: true
        invitationToken unique: true
    }
}
