package linksharing

import com.intelli.linksharing.User

class UserTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static  namespace = "ls"


    def showAdmin = {attr,body ->
      Boolean isAdmin = Boolean.valueOf(attr.isAdmin)
      if(isAdmin) {
          out << body()
      }
    }

    def showUserList = {
        User user = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        User user1 = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        User user2 = new User(email: "abc@gmail.com",username: "monicabamal", password: "igdefault",firstName: "monica",lastName: "bamal");
        List userList = []
        userList.add(user)
        userList.add(user1)
        userList.add(user2)

        out << render(template: "/user/index", model: [userList: userList])

    }
}
