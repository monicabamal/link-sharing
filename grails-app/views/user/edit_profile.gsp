<%--
  Created by IntelliJ IDEA.
  User: monika
--%>

<%@ page import="com.intelli.linksharing.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>

<div class="container">
    <div class="container-left">
        <div class="con-border clearfix">

            <g:render template="/user/user_profile" bean="${user}" var="user"/>
        </div>

        <div class="con-border clearfix">
            <h4>Topics</h4>
            <g:render template="/topic/topic_profile" bean="${com.intelli.linksharing.Topic.get(1)}" var="topic" />
        </div>
    </div>

    <div class="container-right">
        <div class="con-border clearfix">
            <h4>Profile</h4>
            <g:render template="/user/edit_form" bean="${user}" var="user"/>
        </div>
        <div class="con-border clearfix">
            <h4>Change Password</h4>
            <g:render template="/home/change_password"/>
        </div>
    </div>

</div>

</body>
</html>