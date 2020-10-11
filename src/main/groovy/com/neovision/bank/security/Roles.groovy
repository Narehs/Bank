package com.neovision.bank.security


import org.springframework.security.core.GrantedAuthority

enum Roles implements GrantedAuthority {

    ROLE_ADMIN,
    ROLE_USER;

    @Override
    String getAuthority() {
        return name()
    }

    private static final String MESSAGE_PREFIX = "role."

    static Map<String, String> source() {
        return values().collectEntries {
            [(it): (it.getMessage())]
        }
    }

    static Roles findRoleByName(String name) {
        values().find { it.name() == name }
    }
}