package com.fanap.deposit.model;

import com.fanap.deposit.util.IntegerUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Deposit {

    private String customerNumber;
    private String depositType;
    private BigDecimal depositBalance;
    private Integer durationInDays;

    Deposit(String customerNumber,
            String depositType,
            BigDecimal depositBalance,
            Integer durationInDays) {
        this.customerNumber = customerNumber;
        this.depositType = depositType;
        this.depositBalance = depositBalance;
        this.durationInDays = durationInDays;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getDepositType() {
        return depositType;
    }

    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    public Integer getDurationInDays() {
        return durationInDays;
    }

    public boolean isDepositValid() {
        return !(this instanceof InvalidDeposit);
    }

    abstract int getInterestRate();

    public BigDecimal calculatePaidInterest() {
        return BigDecimal.valueOf(getInterestRate())
                .multiply(depositBalance)
                .multiply(BigDecimal.valueOf(durationInDays))
                .divide(BigDecimal.valueOf(IntegerUtil.DIVISION), 0, RoundingMode.HALF_UP);
    }

    public static class Builder {

        private String customerNumber;
        private String depositType;
        private BigDecimal depositBalance;
        private int durationInDays;

        public Deposit.Builder setCustomerNumber(String customerNumber) {
            this.customerNumber = customerNumber;
            return this;
        }

        public Deposit.Builder setDepositType(String depositType) {
            this.depositType = depositType;
            return this;
        }

        public Deposit.Builder setDepositBalance(BigDecimal depositBalance) {
            this.depositBalance = depositBalance;
            return this;
        }

        public Deposit.Builder setDurationInDays(int durationInDays) {
            this.durationInDays = durationInDays;
            return this;
        }

        private boolean isDepositValid() {
            return DepositValidator.depositBalanceValidation(depositBalance) &&
                    DepositValidator.depositTypeValidation(depositType) &&
                    DepositValidator.depositDaysValidation(durationInDays);
        }

        public Deposit build() {
            boolean isDepositValid = isDepositValid();
            if (isDepositValid) {
                return ValidDepositoryFactory.createDeposit(customerNumber, depositType, depositBalance, durationInDays);
            } else {
                return new InvalidDeposit(customerNumber, depositType, depositBalance, durationInDays);
            }
        }

    }

    public String toString() {
        return ("Customer Number: " + customerNumber
                + " | Deposit Type: " + depositType
                + " | Deposit Balance: " + depositBalance
                + " | Duration: " + durationInDays
                + " | and Interest of: " + calculatePaidInterest());
    }
}
