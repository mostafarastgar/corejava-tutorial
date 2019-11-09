package com.saeed.paymentswitch.entity;


public class PaymentOrder008 extends PaymentOrder {
    public PaymentOrder008(String txId, String originator, String beneficiary, Double amount) {
        super(txId, originator, beneficiary, amount);
    }

    @Override
    protected String getPaymentOrderType() {
        return "008";
    }
}