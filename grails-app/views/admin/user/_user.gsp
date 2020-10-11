<!doctype html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>User Profile</title>
</head>

<body>
<div id="content">
<h1>${user.username}</h1>
    <g:if test="${user.account}">
        <h2>
            <span>Account:</span>
            ${user.account.account}
        </h2>
    </g:if> <g:else>
    <button id="createAccount" type="button" name="createAccount">Create Account</button>
</g:else>
<g:render template="user/table/table"/>
    <g:hiddenField name="userId" value="${user.id}"/>
</div>
<g:render template="user/utils/hiddenUrls"/>
<g:render template="user/resource/resource"/>
</body>
</html>