package com.neovision.bank.bootstrap

import grails.core.GrailsApplication
import grails.util.Holders

trait ApplicationBootstrap {

    abstract void execute()

    String getDsDbMode(String dsName) {
        return grailsApplication.config.dataSources."${dsName}".dbCreate
    }

    boolean datasourceIsCreate(String dsName = 'dataSource') {
        String dbCreateMode = getDsDbMode(dsName)
        return dbCreateMode && dbCreateMode.startsWith('create')
    }

    GrailsApplication getGrailsApplication() {
        return Holders.grailsApplication
    }
}