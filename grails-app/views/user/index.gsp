<%@ page import="com.neovision.bank.security.User"%>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<div id="content">
    <h1><span>Email:${user.username}</span></h1>
    <g:each in="${user.account}" var="account">
        <span> ${account.currency} : ${account.account}</span>
    </g:each>
<g:render template="table/table"/>
<br>
<br>
    <g:link controller="user" action="transfer" params="[id:user.id]"><button id="send" type="submit" name="submit">Transfer Money</button></g:link>

</div>
<g:render template="resources/resources"/>
<g:render template="utils/hiddenUrls"/>
</body>
</html>