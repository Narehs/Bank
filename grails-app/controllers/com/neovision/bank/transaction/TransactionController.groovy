package com.neovision.bank.transaction

import com.neovision.bank.utils.NumberUtils
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

@Secured(["ROLE_USER"])
class TransactionController {

    def transactionService

    def withdraw(){
        transactionService.withdraw(NumberUtils.toLong(params.id))
        render(status: HttpStatus.OK.value())
    }
}
