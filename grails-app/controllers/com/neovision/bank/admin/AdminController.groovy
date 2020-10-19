package com.neovision.bank.admin

import com.neovision.bank.currencies.CurrencyEnum
import com.neovision.bank.utils.NumberUtils
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

@Secured(["ROLE_ADMIN"])
class AdminController {

    def userService

    def accountService

    def transactionService

    def index() {
        render(view: 'index', model: [users: userService.getAll()])
    }

    def user() {
        render(view: 'user/_user', model: [user: userService.getOne(NumberUtils.toLong(params.id))])
    }

    def createAccount() {
        List<CurrencyEnum> currencies = new ArrayList<>();
        params.each { param ->
            if (param.getValue().equals("on")) {
                currencies.add(param.key)
            }
        }
        accountService.createAccount(NumberUtils.toLong(params.userId), currencies)
        redirect(controller: 'admin', action: 'user', params: [id: params.userId])
    }

    def createUserPage() {
        render(view: '/admin/createUser/_create')
    }

    def createUser() {
        userService.createUser(params.email, params.password)
        render(status: HttpStatus.OK)
    }

    def accept() {
        transactionService.accept(NumberUtils.toLong(params.id))
    }

    def reject() {
        transactionService.reject(NumberUtils.toLong(params.id))
    }
}
