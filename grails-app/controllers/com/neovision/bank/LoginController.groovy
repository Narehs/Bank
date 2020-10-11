package com.neovision.bank

class LoginController extends grails.plugin.springsecurity.LoginController{

    def auth() {
        ConfigObject conf = getConf()

        if (springSecurityService.isLoggedIn()) {
            redirect uri: conf.successHandler.defaultTargetUrl
            return
        }

        String postUrl = request.contextPath + conf.apf.filterProcessesUrl

        render view: 'login', model: [postUrl            : postUrl,
                                   rememberMeParameter: conf.rememberMe.parameter,
                                   usernameParameter  : conf.apf.usernameParameter,
                                   passwordParameter  : conf.apf.passwordParameter,
                                   gspLayout          : conf.gsp.layoutAuth]
    }
}
