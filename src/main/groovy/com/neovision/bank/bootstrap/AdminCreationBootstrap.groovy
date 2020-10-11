package com.neovision.bank.bootstrap


import com.neovision.bank.security.Roles
import com.neovision.bank.security.User
import com.neovision.bank.config.AppConfig
import com.neovision.bank.security.Role
import com.neovision.bank.security.UserRole
import groovy.util.logging.Slf4j
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
class AdminCreationBootstrap implements ApplicationBootstrap {

    @Override
    void execute() {
        if (datasourceIsCreate('dataSource')) {
            createSystemRoles()
            createAdmin()
        }
    }

    private static void createSystemRoles() {
        Roles.values().each {
            new Role(authority: it.authority).save(flash: true, failOnError: true)
        }
    }

    static void createAdmin() {
        User adminUser = new User(
                username: AppConfig.getDefaultAdminUsername(),
                password: AppConfig.getDefaultAdminPassword(),
                enabled: true
        )
        adminUser.save(flush: true, failOnError: true)
        UserRole.create(adminUser, Role.adminRole)
    }
}
