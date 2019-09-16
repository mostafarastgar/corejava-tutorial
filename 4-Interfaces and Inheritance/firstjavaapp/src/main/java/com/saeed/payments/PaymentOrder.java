package com.saeed.payments;

import java.io.Serializable;

public class PaymentOrder implements PaymentTransaction {
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
    public boolean settle() {
        // TODO: 8/27/2019 transfer amount
        System.out.println("transfer amount from debtor to creditor");
        return true;
    }
}
