package com.neovision.bank.admin


import com.neovision.bank.utils.NumberUtils
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

@Secured(["ROLE_ADMIN"])
class AdminController {

    def userService

    def accountService

    def transactionService

    def index() {
        render(view: 'index', model: [users:userService.getAll()])
    }

    def user(){
        render(view: 'user/_user', model: [user:userService.getOne(NumberUtils.toLong(params.id))])
    }

    def createAccount(){
        accountService.createAccount(NumberUtils.toLong(params.id))
        render(status: HttpStatus.OK)
    }

    def createUserPage(){
        render(view: '/admin/createUser/_create')
    }

    def createUser(){
        userService.createUser(params.email, params.password)
        render(status: HttpStatus.OK)
    }

    def accept(){
        transactionService.accept(NumberUtils.toLong(params.id))
    }

    def reject(){
        transactionService.reject(NumberUtils.toLong(params.id))
    }
}
