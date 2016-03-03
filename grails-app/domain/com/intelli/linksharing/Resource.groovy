package com.intelli.linksharing

import com.intelli.linksharing.co.ResourceSearchCO
import com.intelli.linksharing.vo.RatingInfoVO

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static  transients = ['ratingInfo']

    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

    static mapping = {
        description type: 'text'
    }

    static  namedQueries = {
        search{ ResourceSearchCO rco ->
            if(rco.topicId){
                eq(topic.id, rco.topicId)
            }
            if(rco.visibility){
                eq(topic.visibility, rco.visibility)
            }
        }

    }

    def getRatingInfo(){

        List<RatingInfoVO> ratingInfoVOs = []

        def  ratingInfoList = Resource.createCriteria(){
            projection{
                count(ratings)
                avg(ratings.score)
                sum(ratings.score)
            }
            ratings {
                groupProperty(id)
            }
        }
        ratingInfoList.each {
            RatingInfoVO ratingInfoVO = new RatingInfoVO()
            ratingInfoVO.totalVotes = it[0]
            ratingInfoVO.averageScore = it[1]
            ratingInfoVO.totalScore = it[2]
            ratingInfoVOs.add(ratingInfoVO)
        }
        ratingInfoVOs
    }

}
