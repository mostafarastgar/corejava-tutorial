package com.saeed.paymentswitch.entity;


public class PaymentOrder004 extends PaymentOrder {
    private String orgTxId;

    public PaymentOrder004(String txId, String originator, String beneficiary, Double amount, String orgTxId) {
        super(txId, originator, beneficiary, amount);
        this.orgTxId = orgTxId;
    }

    @Override
    protected String getPaymentOrderType() {
        return "004";
    }
}
