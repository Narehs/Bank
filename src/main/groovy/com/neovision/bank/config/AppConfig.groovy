package com.neovision.bank.config

import grails.util.Holders
import groovy.transform.Memoized

class AppConfig {

    @Memoized
    static String getDefaultAdminUsername() {
        return Holders.config.com.neovision.bank.adminUsername ?: 'admin@gmail.com'
    }

    @Memoized
    static String getDefaultAdminPassword() {
        return Holders.config.com.neovision.bank.adminPassword ?: 'admin'
    }
}
