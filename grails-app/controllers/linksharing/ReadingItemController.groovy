package linksharing

import com.intelli.linksharing.ReadingItem

class ReadingItemController {

    def changeIsRead(long id, Boolean isRead) {
        if(ReadingItem.executeUpdate("update ReadingItem set isRead = :isRead where id= :id",[isRead:isRead, id:id])){
            render "Success !!! "
        }
        else{
            render "Error in updating"
        }
    }
}
