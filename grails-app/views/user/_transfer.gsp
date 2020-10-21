<%@ page import="com.neovision.bank.security.User" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<div id="content">
    <g:hiddenField name="userId" value="${user.id}"/>
    <g:each in="${user.account}" var="account">
        <input type="radio" id="${account.id}" name="accountID" value="${account.account}">
        <label> ${account.currency} : ${account.balance} </label><br>
    </g:each>
    <p>Type Reciver Account number</p>
    <input id="accountNumber" type="number" name="accountNumber"/>
    <button id="searchAccount" type="submit" name="submit">Search</button>

    <g:if test="${account}">
        <g:hiddenField name="hiddenAccountNumber" value="${account.account}"/>
        <p>username : ${account.user.username}</p>
        <input id="amount" type="number" name="amount" min="" max="9"/>
        <button id="transfer" type="submit" name="submit">Transfer</button>
    </g:if>

</div>
<g:render template="utils/hiddenUrls"/>
<g:render template="resources/resources"/>
</body>
</html>