package com.neovision.bank.user

import com.neovision.bank.account.Account
import com.neovision.bank.security.User
import com.neovision.bank.utils.NumberUtils
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

@Secured(["ROLE_USER"])
class UserController {

    def userService

    def accountService

    def transactionService

    def index() {
        render(view: 'index', model: [user: userService.getOne(NumberUtils.toLong(params.id))])
    }

    def transfer() {
        render(view: '_transfer', model: [user: userService.getOne(NumberUtils.toLong(params.id))])
    }

    def createTransaction() {
        transactionService.create(params.accountNumber, params.reciver, NumberUtils.toDouble(params.amount))
        render(status: HttpStatus.OK.value())
    }

    def searchUserByAccount(String accountNumber) {
        Account account = accountService.getAccountByAccountNumber(accountNumber)
        println account
        render template: "/user/transfer", model: [account: account, user: User.findById(NumberUtils.toLong(params.userId))]
    }
}
