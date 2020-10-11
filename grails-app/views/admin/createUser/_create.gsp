<!doctype html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>User Profile</title>
</head>

<body>
<div id="content">
    <span>Email</span>
    <input id="email" type="text" name="email" placeholder="email"/>
    <span>Password</span>
    <input id="password" type="password" name="email" placeholder="password"/>
    <button id="create" type="submit" name="create">Create</button>
</div>
<g:render template="createUser/utils/hiddenUrls"/>
<g:render template="createUser/resource/resource"/>
</body>
</html>