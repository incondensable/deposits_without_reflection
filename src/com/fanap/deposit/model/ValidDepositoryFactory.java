package com.fanap.deposit.model;

import java.math.BigDecimal;

class ValidDepositoryFactory {

    static Deposit createDeposit(String customerNumber,
                                 String depositType,
                                 BigDecimal depositBalance,
                                 Integer durationInDays) {
        switch (depositType) {
            case "Qarz":
                return new QarzDeposit(customerNumber, depositType, depositBalance, durationInDays);
            case "ShortTerm":
                return new ShortTermDeposit(customerNumber, depositType, depositBalance, durationInDays);
            default:
                return new LongTermDeposit(customerNumber, depositType, depositBalance, durationInDays);
        }

    }

}
