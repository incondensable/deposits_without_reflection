package com.fanap.deposit.model;

import java.math.BigDecimal;

public class ShortTermDeposit extends Deposit {

    public ShortTermDeposit(String customerNumber, String depositType, BigDecimal depositBalance, Integer durationInDays) {
        super(customerNumber, depositType, depositBalance, durationInDays);
    }

    @Override
    int getInterestRate() {
        return 10;
    }

}
