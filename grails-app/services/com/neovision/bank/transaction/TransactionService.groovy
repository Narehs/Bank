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
            senderAccount.balance -= amount
            sender.save(flush: true)

            return sender
        }
        return sender
    }

    Transaction withdraw(Long id) {
        Transaction transaction = Transaction.findByIdAndStatus(id, TransactionStatus.PENDING)
        if (transaction) {
            User user = transaction.user
            Account account = user.account.find { it -> it.id == transaction.sendingAccountId }
            account.balance += transaction.amount
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
        BigDecimal amountCurrency = senderTransaction.amount * rate
        Transaction transaction = new Transaction(sendingAccountId: senderTransaction.sendingAccountId,
                receivingAccountId: senderTransaction.receivingAccountId, amount: amountCurrency,
                status: TransactionStatus.ACCEPTED, type: TransactionType.WITHDRAWAL)
        receiverAccount.balance += amountCurrency
        User receiver = receiverAccount.user
        receiver.addToTransactions(transaction)
        receiver.save(flush: true)

        return senderTransaction

    }

    Transaction reject(Long id) {
        Transaction transaction = Transaction.findByIdAndStatus(id, TransactionStatus.PENDING)
        if (transaction) {
            User user = transaction.user
            Account account = user.account.find { it -> it.id == transaction.sendingAccountId }
            account.balance += transaction.amount
            transaction.status = TransactionStatus.REJECTED
            user.save(flush: true)
        }
        return transaction
    }

    private User resolveUser() {
        springSecurityService.currentUser as User
    }
}
