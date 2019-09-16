package com.saeed.payments;

public abstract class PaymentOrder implements PaymentTransaction {
    String txId;
    private String debtor;
    private String creditor;
    private Double amount;
    private String settleDate;

    public PaymentOrder(String txId) {
        this.txId = txId;
    }

    @Override
    public String getTxId() {
        return this.txId;
    }

    @Override
    public final boolean settle() {
        transferAccount();
        save();
        return true;
    }

    protected void save() {
        System.out.println("save payment order");
    }

    protected abstract void transferAccount();
}
