package com.saeed.paymentswitch.entity;


public class PaymentOrderOrder004 extends PaymentOrder {
    private String orgTxId;

    public PaymentOrderOrder004(String txId, String originator, String beneficiary, Double amount, String orgTxId) {
        super(txId, originator, beneficiary, amount);
        this.orgTxId = orgTxId;
    }

    @Override
    protected String getPaymentOrderType() {
        return "004";
    }
}
