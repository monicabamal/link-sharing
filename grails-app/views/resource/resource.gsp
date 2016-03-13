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
    <div class="container-left" style="width: 60%">
        <div class="con-border clearfix">
            <h4>Topic : "$"</h4>
            <g:render template="/resource/resource_profile" bean="${resource}" var="resource"/>
        </div>
    </div>
    <div class="container-right">
        <div class="con-border">
            <h4>Trending Topic</h4>
            <div id="trendingTopic">
            <g:render template="/resource/resource_list" bean="${topResources}" var="resources" model="[paginateController:'linkResource',paginateAction:'trendingTopic',updateId:'trendingTopic',totalResource:'10']"/>
            </div>
        </div>
    </div>


</div>

</body>



</html>