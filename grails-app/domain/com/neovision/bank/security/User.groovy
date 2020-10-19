package com.neovision.bank.security


import com.neovision.bank.account.Account
import com.neovision.bank.transaction.Transaction
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'username')
@ToString(includes = ['username', 'id'], includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService

    Long id
    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Account> account
    Set<Transaction> transactions

    static hasMany = [account: Account, transactions: Transaction]

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, email: true, unique: true
        account nullable: true

    }

    static mapping = {
        id generator: 'sequence', params: [sequence: 'BANK_SEQUENCE']
        password column: '`password`'
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }
}
