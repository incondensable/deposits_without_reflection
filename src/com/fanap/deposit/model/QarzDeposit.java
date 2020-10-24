package com.fanap.deposit.model;

import java.math.BigDecimal;

public class QarzDeposit extends Deposit {

    QarzDeposit(String customerNumber, String depositType, BigDecimal depositBalance, Integer durationInDays) {
        super(customerNumber, depositType, depositBalance, durationInDays);
    }

    @Override
    int getInterestRate() {
        return 0;
    }
}
