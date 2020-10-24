package com.fanap.deposit.output;

import com.fanap.deposit.model.Deposit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DepositFilePrinterImpl implements DepositPrinter {

    @Override
    public boolean print(List<Deposit> deposits) {

        try {
            FileWriter fileWriter =
                    new FileWriter("com.fanap.deposit.output.txt");

            StringBuilder depositTextResultBuilder = new StringBuilder();

            for (int i = 0; i < deposits.size(); i++) {
                Deposit deposit = deposits.get(i);

                depositTextResultBuilder
                        .append(String.format("%d - Customer Number : %s ",
                                (i + 1),
                                deposit.getCustomerNumber()));

                if (deposit.isDepositValid()) {
                    depositTextResultBuilder
                            .append(String.format("Customer Type : %s, Paid Interest : %f",
                                    deposit.getDepositType(),
                                    deposit.calculatePaidInterest()));
                } else {
                    depositTextResultBuilder.append("Is invalid");
                }

                if (i != deposits.size() -1) {
                    depositTextResultBuilder.append("\n");
                }

            }

            fileWriter.write(depositTextResultBuilder.toString());
            fileWriter.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}
