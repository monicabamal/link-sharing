package com.intelli.linksharing.vo

import com.intelli.linksharing.User
import com.intelli.linksharing.enums.Visibility

/**
 * Created by ttnd on 29/2/16.
 */
class TopicVO {

    long id
    String name
    Visibility visibility
    int count
    User createdBy

}
