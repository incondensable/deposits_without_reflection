package com.fanap.deposit.output;

public class DepositPrinterFactory {

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    public static DepositPrinter provideDepositPrinter(PrinterMethod printerMethod) {
        switch (printerMethod) {
            case FILE:
                return new DepositFilePrinterImpl();
            default:
                throw new IllegalArgumentException("Invalid printer method");
        }
    }

    public enum PrinterMethod {
        FILE;
    }

}
