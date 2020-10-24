package com.fanap.deposit.model;

import java.math.BigDecimal;

public class LongTermDeposit extends Deposit {

    public LongTermDeposit(String customerNumber, String depositType, BigDecimal depositBalance, Integer durationInDays) {
        super(customerNumber, depositType, depositBalance, durationInDays);
    }

    @Override
    int getInterestRate() {
        return 20;
    }

}
