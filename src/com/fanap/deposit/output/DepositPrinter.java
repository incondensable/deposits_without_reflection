package com.fanap.deposit.output;

import com.fanap.deposit.model.Deposit;

import java.util.List;

public interface DepositPrinter {
    boolean print(List<Deposit> deposits);
}
