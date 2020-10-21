package com.neovision.bank.transaction

import com.neovision.bank.account.Account
import com.neovision.bank.currencyConvert.CurrencyExchange
import com.neovision.bank.security.User
import org.springframework.beans.factory.annotation.Autowired

class TransactionService {

    def springSecurityService

    @Autowired
    CurrencyExchange currencyExchange

    User create(String senderAccountNumber, String receiverAccountNumber, Double amount) {
        Account senderAccount = Account.findByAccount(senderAccountNumber)
        Account receiverAccount = Account.findByAccount(receiverAccountNumber)
        User sender = senderAccount.user
        if (senderAccount != receiverAccount && senderAccount.balance >= amount) {
            sender.addToTransactions(new Transaction(sendingAccountId: senderAccount.id, receivingAccountId: receiverAccount.id,
                    amount: amount, status: TransactionStatus.PENDING, type: TransactionType.DEPOSIT))
            //senderAccount.balance -= amount
            sender.save(flush:true)

            return sender
        }
        return sender
    }

    Transaction withdraw(Long id) {
        Transaction transaction = Transaction.findByIdAndStatus(id, TransactionStatus.PENDING)
        if (transaction) {
            User user = transaction.user
            user.account.balance += transaction.amount
            transaction.status = TransactionStatus.REJECTED
            user.save(flush: true)
        }
        return transaction
    }

    Transaction accept(Long id) {
        Transaction senderTransaction = Transaction.findByIdAndStatus(id, TransactionStatus.PENDING)
        if (senderTransaction) {
            senderTransaction.status = TransactionStatus.ACCEPTED
            senderTransaction.save(flush: true)
        }
        Account senderAccount = Account.findById(senderTransaction.sendingAccountId)
        Account receiverAccount = Account.findById(senderTransaction.receivingAccountId)
        BigDecimal rate = currencyExchange.getRate(senderAccount.currency.toString(), receiverAccount.currency.toString())
        Transaction transaction = new Transaction(sendingAccountId: senderTransaction.sendingAccountId,
                receivingAccountId: senderTransaction.receivingAccountId, amount: senderTransaction.amount * rate,
                status: TransactionStatus.ACCEPTED, type: TransactionType.WITHDRAWAL)
        User receiver = receiverAccount.user
        receiver.transactions.add(transaction)
        transaction.user = receiver
        receiver.save(flush:true)

        return senderTransaction

    }

    Transaction reject(Long id) {
        Transaction transaction = Transaction.findByIdAndStatus(id, TransactionStatus.PENDING)
        if (transaction) {
            transaction.status = TransactionStatus.REJECTED
            transaction.save(flush: true)
        }
        return transaction
    }

    private User resolveUser() {
        springSecurityService.currentUser as User
    }
}
