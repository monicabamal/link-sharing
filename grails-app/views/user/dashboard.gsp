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
    <div class="${session.username?"container-left":""}">
        <div class="con-border clearfix">

            <g:render template="/user/user_profile"/>
        </div>

        <div class="con-border clearfix">
            <h4>Subscriptions</h4>
            <g:render template="/topic/topic_list" bean="topics"/>
        </div>
    </div>
    <g:if test="${session.username}">
        <div class="container-right">
            <div class="con-border">
                <h4>Inbox</h4>

                <div id="userInbox">
                    <g:render template="/resource/resource_list" bean="${readingItems}" var="resources"
                              model="[paginateController: 'linkResource', paginateAction: 'inbox', paginateId: params.id, updateId: 'userInbox', totalResource: 10]"/>
                </div>
            </div>
        </div>
    </g:if>
</div>

</body>
</html>