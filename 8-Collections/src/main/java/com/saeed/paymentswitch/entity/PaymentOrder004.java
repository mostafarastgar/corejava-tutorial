package com.saeed.paymentswitch.entity;


public class PaymentOrder004 extends PaymentOrder {
    private String orgTxId;

    public PaymentOrder004(String txId, String originator, String beneficiary, Long amount, String orgTxId) {
        super(txId, originator, beneficiary, amount);
        this.orgTxId = orgTxId;
    }

    @Override
    public String getPaymentOrderType() {
        return "004";
    }
}
