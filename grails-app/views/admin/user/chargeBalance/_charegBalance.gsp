<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<div id="content">
    <h1>${selectedUser.username}</h1>
    Account Number<p> ${account.account}</p>
    Account balance<p> ${account.balance}</p>
    ${account.currency} <input id="amount" type="number" name="amount" min=""/>
    <g:hiddenField name="accountNumber" value="${account.account}"/>
    <button id="changeAccBalance" type="submit" name="submit">changeBalance</button>
</div>
<g:render template="user/utils/hiddenUrls"/>
<g:render template="user/resource/resource"/>
</body>
</html>