package com.neovision.bank.utils

import java.math.RoundingMode

class NumberUtils {

    private NumberUtils() {
    }

    public static Long toLong(String value) {
        if (value != null) {
            try {
                return Long.valueOf(value);
            } catch (NumberFormatException ignored) {
            }
        }
        return null;
    }

    public static Integer toInteger(String value) {
        if (value != null) {
            try {
                return Integer.valueOf(value);
            } catch (NumberFormatException ignored) {
            }
        }
        return null;
    }

    public static Double toDouble(String value) {
        if (value != null) {
            try {
                return Double.valueOf(value);
            } catch (NumberFormatException ignored) {

            }
        }
        return null;
    }

    public static String formatBigDecimal(BigDecimal decimal) {
        return decimal ? decimal.setScale(2, RoundingMode.FLOOR).toString() : StringUtils.EMPTY
    }
}
