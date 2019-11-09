package com.saeed.paymentswitch.entity;


public class PaymentOrder008 extends PaymentOrder {
    public PaymentOrder008(String txId, String originator, String beneficiary, Long amount) {
        super(txId, originator, beneficiary, amount);
    }

    @Override
    public String getPaymentOrderType() {
        return "008";
    }
}