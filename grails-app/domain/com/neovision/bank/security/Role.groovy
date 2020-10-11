package com.neovision.bank.security

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.Memoized
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'authority')
@ToString(includes = 'authority', includeNames = true, includePackage = false)
class Role implements Serializable {

    private static final long serialVersionUID = 1

    String authority

    static constraints = {
        authority blank: false, unique: true
    }

    static mapping = {
        cache true
    }


    @Memoized
    static Role getAdminRole() {
        return Role.findByAuthority(Roles.ROLE_ADMIN.name())
    }

    @Memoized
    static Role getUserRole() {
        return Role.findByAuthority(Roles.ROLE_USER.name())
    }
}
