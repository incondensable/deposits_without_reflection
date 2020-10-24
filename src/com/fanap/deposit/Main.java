package com.fanap.deposit;

import com.fanap.deposit.convertor.XmlConvertor;
import com.fanap.deposit.model.Deposit;
import com.fanap.deposit.output.DepositPrinter;
import com.fanap.deposit.output.DepositPrinterFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepositPrinter depositPrinter = DepositPrinterFactory
                .provideDepositPrinter(DepositPrinterFactory.PrinterMethod.FILE);
        List<Deposit> deposits = XmlConvertor.convertXmlToDeposit("resource/Deposits.txt");
        boolean isSuccessful = depositPrinter.print(deposits);
        System.out.println("The deposits have been printed " + (isSuccessful ? "successfully !" : "with an error."));
    }
}