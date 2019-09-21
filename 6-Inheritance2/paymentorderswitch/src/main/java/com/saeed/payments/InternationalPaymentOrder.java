package com.saeed.payments;

public class InternationalPaymentOrder implements PaymentTransaction {
    private String txId;

    public InternationalPaymentOrder(String txId) {
        this.txId = txId;
    }

    @Override
    public boolean settle() {
        return true;
    }

    @Override
    public String getTxId() {
        return txId;
    }

    @Override
    public String getOwner() {
        return "EUR";
    }
}
