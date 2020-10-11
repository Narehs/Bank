
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<div id="content">
<g:render template="users/users"/>
    <g:link controller="admin" action="createUserPage">Create User</g:link>
</div>
</body>
</html>