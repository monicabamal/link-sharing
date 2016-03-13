package com.intelli.linksharing


class MonthlyNotificationJob {

def linksharingMailService

    static triggers = {
        cron name: 'myTrigger', cronExpression: "0 0 6 1 * ?" // execute job once in WEEK
    }

    def execute() {
        // execute job

        Map subscribers=linksharingMailService.weeklyMailSubscriber()

        subscribers.each {item->
            linksharingMailService.sendMail(new MailCO(to : item.value[1], body : "check update" , subject: item.key))

        }

    }
}
