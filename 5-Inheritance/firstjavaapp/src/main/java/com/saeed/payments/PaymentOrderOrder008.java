package com.saeed.payments;

public class PaymentOrderOrder008 extends PaymentOrder {
    public PaymentOrderOrder008(String txId) {
        super(txId);
    }

    @Override
    protected void transferAccount() {
        System.out.println("withdraw debtor and deposit creditor");
    }
}