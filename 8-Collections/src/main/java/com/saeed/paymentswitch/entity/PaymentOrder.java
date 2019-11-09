package com.saeed.paymentswitch.entity;

import java.time.LocalDateTime;

public abstract class PaymentOrder implements PaymentTransaction {
    String txId;
    private String originator;
    private String beneficiary;
    private Long amount;
    private LocalDateTime settleDate;

    public PaymentOrder(String txId, String originator, String beneficiary, Long amount) {
        this.txId = txId;
        this.originator = originator;
        this.beneficiary = beneficiary;
        this.amount = amount;
        this.settleDate = LocalDateTime.now();

    }

    @Override
    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId + "-" + getPaymentOrderType();
    }

    @Override
    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    @Override
    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    @Override
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDateTime getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(LocalDateTime settleDate) {
        this.settleDate = settleDate;
    }

    public abstract String getPaymentOrderType();

    @Override
    public String toString() {
        return "PaymentOrder{" +
                "txId='" + txId + '\'' +
                ", originator='" + originator + '\'' +
                ", beneficiary='" + beneficiary + '\'' +
                ", amount=" + amount +
                ", settleDate=" + settleDate +
                ", paymentOrderType=" + getPaymentOrderType() +
                '}';
    }
}
