package com.neovision.bank


import com.neovision.bank.bootstrap.ApplicationBootstrap
import org.springframework.beans.factory.annotation.Autowired

class BootStrap {

    @Autowired
    List<ApplicationBootstrap> applicationBootstraps

    def init = { servletContext ->
        applicationBootstraps.each {
            it.execute()
        }
    }
    def destroy = {
    }
}
