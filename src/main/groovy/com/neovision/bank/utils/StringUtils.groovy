package com.neovision.bank.utils

class StringUtils {
    private StringUtils() {

    }

    static int generateRandomDigits() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 100000000 + r.nextInt(100000000));
    }
}