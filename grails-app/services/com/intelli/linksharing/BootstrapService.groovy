package com.intelli.linksharing

import grails.transaction.Transactional

@Transactional
class BootstrapService {


    void createUsers() {

        5.times { count ->
            User user = new User(firstName: 'admin', email: "admin${count}@intelligrape.com", userName: "admin${count}", password: "admin123", admin: true, active: true)

            if (user.validate()) {
                user.save(failOnError: true)
            }
        }


    }

    void createTopic() {
        5.times { count ->
            Topic topic = new Topic(name: "Grails${count}", createdBy: User.findByUserName("admin${count}"), visibility: Visibility.PUBLIC, description: "This Topic is related to Grails ${count}")
            if (topic.validate()) {
                println topic.save(failOnError: true)
            }
        }
    }

    void createSubscription() {
        5.times { count ->
            5.times { count2 ->
                Subscription subscription = new Subscription(topic: Topic.findByName("Grails${count2}"), user: User.findByUserName("admin${count}"), seriousness: Seriousness.VERYSERIOUS, dateCreated: new Date());
                if (subscription.validate()) {
                    println subscription.save(failOnError: true)
                }
            }
        }
    }

    void createResource() {
        3.times { count ->
            Resource resource = new LinkResource(topic: Topic.findByName("Grails${count}"), createdBy: User.findByUserName("admin${count}"), description: "She sees our approach to food as a kind of behavior, in itself a description of the nuances of character.\n" +
                    "His description of his own actions on the night of the speech must be seen in that light.\n" +
                    "Go through the job description line by line.\n" +
                    "One problem for the early committees was deciding what Nobel had meant by his rather sketchy description of the prizes.\n" +
                    "They displayed a minor talent for colorful description but none, alas, for punch lines.\n" +
                    "Send us your best travel pics and a trip description of 250 words or less.\n" +
                    "The cover letter should include a description of your previous research experience and long-term career goals.", url: "http://bootcamp.intelligrape.com/grails${count}.pdf")
            if(resource.validate()){
                resource.save(failOnError: true)
            }

        }

        3.upto(4) { count ->
            Resource resource = new DocumentResource(topic: Topic.findByName("Grails${count}"), createdBy: User.findByUserName("admin${count}"), description: "She sees our approach to food as a kind of behavior, in itself a description of the nuances of character.\n" +
                    "His description of his own actions on the night of the speech must be seen in that light.\n" +
                    "Go through the job description line by line.\n" +
                    "One problem for the early committees was deciding what Nobel had meant by his rather sketchy description of the prizes.\n" +
                    "They displayed a minor talent for colorful description but none, alas, for punch lines.\n" +
                    "Send us your best travel pics and a trip description of 250 words or less.\n" +
                    "The cover letter should include a description of your previous research experience and long-term career goals.", filePath: "bootcamp.intelligrape.com/grails${count}.pdf", contentType: "pdf")
            if (resource.validate()) {
                println resource.save(failOnError: true)
            }
        }

    }

    void readItem() {
        3.times {
            ReadingItem readingItem = ReadingItem.findById(it + 1)
            readingItem.isRead = true
            if(readingItem.validate()){
            readingItem.save(failOnError: true)
            }

        }
    }

    void rateResource(){
        5.times { count->
            5.times {count2->
                ResourceRating resourceRating= new ResourceRating(resource: Resource.get(count2+1),user: User.get(count+1) ,score :count+count2%6 )
                if(resourceRating.validate()){
                resourceRating.save(failOnError: true)
                }
            }

        }

    }



}
