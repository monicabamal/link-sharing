<%--
  Created by IntelliJ IDEA.
  User: monika
--%>

<%@ page import="com.intelli.linksharing.Resource" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>

<div class="container">
    <div class="container-left">
        <div class="con-border clearfix" >
                <h4>Recent Shares</h4>
            <div id="recentShares">
            <g:render template="/resource/resource_list" bean="${resources}" var="resources" model="[paginateController:'linkResource',paginateAction:'recentShares',updateId:'recentShares',totalResource:'10']"/>
            </div>

        </div>
        <div class="con-border clearfix" >
            <h4>Top Posts</h4>
            <div id="topPosts">
        <g:render template="/resource/resource_list" bean="${topResources}" var="resources" model="[paginateController:'linkResource',paginateAction:'topResources',updateId:'topPosts',totalResource:'10']"/>
            </div>
            </div>
    </div>
    <div class="container-right container-fluid">
        <div class="con-border  clearfix">
        <g:render template="/login/login_form"/>
        </div>
        <div class="con-border clearfix">
        <g:render template="/user/create_form"/>
        </div>
    </div>


</div>
%{--<script>--}%
    %{--$(document).ready(function() {--}%
        %{--$('#login_form').formValidation({--}%
            %{--framework: 'bootstrap',--}%
            %{--icon: {--}%
                %{--valid: 'glyphicon glyphicon-ok',--}%
                %{--invalid: 'glyphicon glyphicon-remove',--}%
                %{--validating: 'glyphicon glyphicon-refresh'--}%
            %{--},--}%
            %{--fields: {--}%
                %{--userName: {--}%
                    %{--validators: {--}%
                        %{--notEmpty: {--}%
                            %{--message: 'The username is required'--}%
                        %{--}--}%
                    %{--}--}%
                %{--},--}%
                %{--password: {--}%
                    %{--validators: {--}%
                        %{--notEmpty: {--}%
                            %{--message: 'The password is required'--}%
                        %{--}--}%
                    %{--}--}%
                %{--}--}%
            %{--}--}%
        %{--});--}%
    %{--});--}%
%{--</script>--}%

</body>
</html>