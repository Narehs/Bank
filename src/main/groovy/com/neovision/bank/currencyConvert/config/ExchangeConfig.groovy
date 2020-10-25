package com.neovision.bank.currencyConvert.config


import grails.util.Holders
import groovy.transform.Memoized

class ExchangeConfig {

    @Memoized
    static String getExchangeKey() {
        return Holders.config.com.neovision.bank.key ?: ''
    }

    @Memoized
    static String getExchangeQ() {
        return Holders.config.com.neovision.bank.q ?: ''
    }

    @Memoized
    static String getExchangeScheme() {
        return Holders.config.com.neovision.bank.scheme ?: ''
    }

    @Memoized
    static String getExchangeHost() {
        return Holders.config.com.neovision.bank.host ?: ''
    }

    @Memoized
    static String getExchangePath() {
        return Holders.config.com.neovision.bank.path ?: ''
    }

}