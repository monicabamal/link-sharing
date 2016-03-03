<%--
  Created by IntelliJ IDEA.
  User: ttnd
  Date: 22/2/16
  Time: 3:13 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Hello</title>
    <meta name="layout" content="index" />
</head>

<body>
    <g:eachError bean="${user}">
        <li></li><g:message error="${it}"/></li>
    </g:eachError>
</body>
</html>