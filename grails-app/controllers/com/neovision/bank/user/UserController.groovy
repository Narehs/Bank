package com.neovision.bank.user

import com.neovision.bank.transaction.Transaction
import com.neovision.bank.utils.NumberUtils
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

@Secured(["ROLE_USER"])
class UserController {

    def userService

    def transactionService

    def index() {
        render(view: 'index', model: [user:userService.getOne(NumberUtils.toLong(params.id))])
    }

    def createTransaction(){
        transactionService.create(params.email, NumberUtils.toDouble(params.amount))
        render(status: HttpStatus.OK.value())
    }
}
