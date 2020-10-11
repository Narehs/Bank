<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title></title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no,minimal-ui">
    <asset:stylesheet src="pages/login-page.scss"/>
    <asset:javascript src="application.js"/>
</head>

<body>

<div id="content" role="main" class="login-page">
    <div class="login-page-wrap">
        <div class="login-page-content">
            <h2>Sign In</h2>
            <g:form controller="login" action="authenticate" data-name="Email Form" name="loginForm"
                    class="form-2 w-clearfix" autocomplete="off" method="POST">
                <div class="input-field-wrap with-icon">
                    <label class="input-field">
                        <i class="icon-user"></i>
                        <input type="text" name="${usernameParameter ?: 'username'}" data-name="username"
                               placeholder="Type your email" id="username">
                        <span class="label">Email</span>
                    </label>
                    <span class="field-error">This field is required !</span>
                </div>

                <div class="input-field-wrap with-icon password">
                    <label class="input-field">
                        <i class="icon-lock"></i>
                        <input type="password" name="${passwordParameter ?: 'password'}" data-name="Password"
                               placeholder="Type your password" id="password">
                        <span class="label">Password</span>
                        <i class="icon-eye"></i>
                    </label>
                    <span class="field-error">This field is required !</span>
                </div>

                <g:if test='${flash.message}'>
                    <div class="messages-wrap error top-space">
                        <p>${flash.message} <i class="icon-close"></i></p>
                    </div>
                </g:if>

                <div class="button-wrap">
                    <button class="button blue">Sign In</button>
                </div>
            </g:form>
        </div>
    </div>
</div>
<asset:javascript src="/auth/login.js"/>
<asset:javascript src="commons/notifications.js"/>
<asset:javascript src="auth/auth.js"/>
<script>
    ( function () {
        document.forms[ 'loginForm' ].elements[ '${usernameParameter ?: 'username'}' ].focus();
    } )();
</script>
</body>
</html>
