package com.saeed.payments;

public class PaymentOrder implements PaymentTransaction{
    private String txId;
    private String debtor;
    private String creditor;
    private Double amount;
    private String settleDate;


    @Override
    public boolean settle() {
        // TODO: 8/27/2019 transfer amount
        System.out.println("transfer amount from debtor to creditor");
        return true;
    }
}
