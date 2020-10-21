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
            <g:each in="${user.account}" var="account">
                <span> ${account.currency} : ${account.account}</span>
            </g:each>
        </h2>
    </g:if>
    <g:else>
        <g:form controller="admin" action="createAccount">
            AMD <g:checkBox name="AMD"/>
            EURO <g:checkBox name="EUR"/>
            USD <g:checkBox name="USD"/>
            RUB <g:checkBox name="RUB"/>
            <g:hiddenField name="userId" value="${user.id}"/>
            <g:actionSubmit value="createAccount"/>
        </g:form>
    </g:else>
<g:render template="user/table/table"/>
</div>
<g:render template="user/utils/hiddenUrls"/>
<g:render template="user/resource/resource"/>
</body>
</html>