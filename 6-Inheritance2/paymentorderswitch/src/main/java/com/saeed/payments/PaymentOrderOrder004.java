package com.saeed.payments;

public class PaymentOrderOrder004 extends PaymentOrder {
    private String orgTxId;
    private String txId;

    public PaymentOrderOrder004(String txId, String orgTxId) {
        super(txId);
        int a = 10;
    }

    @Override
    protected void save() {
        super.save();
        System.out.println("save additional info");
    }

    @Override
    protected void transferAccount() {
        System.out.println("withdraw creditor and deposit debtor");
    }
}
