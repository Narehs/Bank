package com.neovision.bank.account

import com.neovision.bank.currencies.CurrencyEnum
import com.neovision.bank.security.User
import com.neovision.bank.utils.StringUtils

class AccountService {
    List<Account> createAccount(Long userId, List<CurrencyEnum> currencies) {
        User user = User.findById(userId)
        currencies.each { currency ->
            Account account = new Account();
            if (user) {
                account.account = StringUtils.generateRandomDigits()
                account.balance = 10000000
                account.currency = currency
                account.user =  user
                user.account.add(account)
            }
        }
        user.save(flush: true)
        return user.account.toList()
    }

    Account getAccountByAccountNumber(String accountNumber) {
        Account account = Account.findByAccount(accountNumber)
        if (account != null)
            return account
        else
            return null
    }
}
