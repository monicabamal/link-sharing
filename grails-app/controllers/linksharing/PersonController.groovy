package linksharing

import com.intelli.linksharing.co.PersonCO
import grails.validation.Validateable

@Validateable
class PersonController {

    def index(PersonCO person) {
       render  person.validate()
        render "<br>"
        render person.errors.getFieldError("name").rejectedValue
    }
}
