<%--
  Created by IntelliJ IDEA.
  User: monika
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>

<div class="container">
    <div class="container-left">
        <div class="con-border clearfix">
            <h4>Topic : "${topic.name}"</h4>
        <g:render template="/topic/topic_profile" bean="topic"/>
        </div>
        <div class="con-border clearfix">
            <h4>Subscribers</h4>
        <g:render template="/topic/subscriber_list" bean="${topic.subscription.user}" var="subscribers"/>
            </div>
    </div>
    <div class="container-right">
        <div class="con-border">
            <h4>Posts : "${topic.name}"</h4>
            <g:render template="/resource/resource_list" bean="${resources}" var="resources" model="[paginateController:'linkResource',paginateAction:'trendingTopic',updateId:'trendingTopic',totalResource:'10',paginateId:topic.id]"/>
        </div>
    </div>


</div>

</body>
</html>