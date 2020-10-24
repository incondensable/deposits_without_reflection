package com.fanap.deposit.model;

import java.math.BigDecimal;

class DepositValidator {

    public static Boolean depositBalanceValidation(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        return true;
    }

    public static Boolean depositDaysValidation(Integer days) {
        if (days.compareTo(0) <= 0) {
            return false;
        }
        return true;
    }

    public static Boolean depositTypeValidation(String type) {
        if (type.equals("Qarz") || type.equals("ShortTerm") || type.equals("LongTerm")) {
            return true;
        } else return false;
    }

}