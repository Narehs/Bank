package com.neovision.bank.transaction

import com.neovision.bank.security.User

class TransactionService {

    def springSecurityService

    Transaction create(String receiverMail, Double amount){
        Transaction transaction = new Transaction()
        User sender = resolveUser()
        User receiver = User.findByUsername(receiverMail)
        if (sender.account && sender.account.balance >= amount && receiver.account){
            transaction = new Transaction(sendingAccountId: sender.account.id, receivingAccountId: receiver?.account?.id,
                    amount:amount, status: TransactionStatus.PENDING, type: TransactionType.DEPOSIT)
            transaction.user = sender
            sender.transactions.add(transaction)
            sender.account.balance -= amount
            sender.save(flush:true, failOnError:true)
            return transaction
        }
        return transaction
    }

    Transaction withdraw(Long id){
        Transaction transaction = Transaction.findByIdAndStatus(id,TransactionStatus.PENDING)
        if (transaction) {
            User user = transaction.user
            user.account.balance += transaction.amount
            transaction.status = TransactionStatus.REJECTED
            user.save(flush: true)
        }
        return transaction
    }

    Transaction accept(Long id){
        Transaction transaction = Transaction.findByIdAndStatus(id, TransactionStatus.PENDING)
        if (transaction){
            transaction.status = TransactionStatus.ACCEPTED
            transaction.save(flush:true)
        }
        return transaction

    }

    Transaction reject(Long id){
        Transaction transaction = Transaction.findByIdAndStatus(id, TransactionStatus.PENDING)
        if (transaction){
            transaction.status = TransactionStatus.REJECTED
            transaction.save(flush:true)
        }
        return transaction
    }

    private User resolveUser(){
        springSecurityService.currentUser as User
    }
}
