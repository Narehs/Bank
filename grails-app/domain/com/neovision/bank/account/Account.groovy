package com.neovision.bank.account


import com.neovision.bank.security.User
import org.joda.time.LocalDate

class Account {

    String account

    LocalDate createdDate = LocalDate.now()
    BigDecimal balance = BigDecimal.ZERO

    User user

    static belongsTo = [user: User]

    static constraints = {
        account nullable: false, blank: false, unique: true, maxSize: 12
        createdDate nullable: false
        balance nullable: false, max: new BigDecimal(100000000000000)
    }
}
