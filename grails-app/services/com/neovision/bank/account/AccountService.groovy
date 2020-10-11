package com.neovision.bank.account

import com.neovision.bank.security.User
import com.neovision.bank.utils.StringUtils

class AccountService {
    Account createAccount(Long userId){
        User user = User.findById(userId)
        Account account = new Account();
        if (user){
            account.account = StringUtils.generateRandomDigits()
            account.balance = 10000000
            user.account = account
            user.save(flush:true)
        }
        return account
    }
}
