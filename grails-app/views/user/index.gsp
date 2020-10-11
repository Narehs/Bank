<%@ page import="com.neovision.bank.security.User"%>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<div id="content">
    <h1><span>Email:${user.username}</span></h1>
    <h1><span>Balance:${user?.account?.balance}</span></h1>
<g:render template="table/table"/>
<br>
<br>
<span>Email</span>
<select id="users" name="users">
   <g:each in="${User.findAll()}" var="selectedUser">
       <option value="${selectedUser.username}">${selectedUser.username}</option>
   </g:each>
</select>
<span>Amount</span>
<input id="amount" type="number" name="balance" min="" max="9"/>
<button id="send" type="submit" name="submit">Send</button>
</div>
<g:render template="utils/hiddenUrls"/>
<g:render template="resources/resources"/>
</body>
</html>