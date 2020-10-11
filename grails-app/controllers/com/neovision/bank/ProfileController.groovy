package com.neovision.bank


import com.neovision.bank.security.User
import com.neovision.bank.security.Role
import grails.plugin.springsecurity.SpringSecurityService
import groovy.util.logging.Slf4j
import org.springframework.security.access.annotation.Secured

import javax.annotation.Resource

@Secured(["ROLE_ADMIN","ROLE_USER"])
class ProfileController {

    @Resource
    SpringSecurityService springSecurityService

    def index() {
        User user = springSecurityService.currentUser as User

        if (!user) {
            return
        }

        if (user.authorities.contains(Role.adminRole)) {
            redirect(controller: 'admin', action: 'index', id: user.id)
        } else if (user.authorities.contains(Role.userRole)) {
            redirect(controller: 'user', action: 'index', id: user.id)
        }

    }
}
