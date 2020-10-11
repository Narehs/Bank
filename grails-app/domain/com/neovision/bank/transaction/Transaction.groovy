package com.neovision.bank.transaction

import com.neovision.bank.security.User
import org.joda.time.LocalDate

class Transaction {

    Long sendingAccountId
    Long receivingAccountId
    BigDecimal amount
    TransactionStatus status
    TransactionType type
    LocalDate transactionDate = LocalDate.now()

    User user

    static belongsTo = [user:User]

    static constraints = {
        sendingAccountId nullable: false
        receivingAccountId nullable: true
        amount nullable: false
        status nullable: false
        type nullable: false
    }
}
