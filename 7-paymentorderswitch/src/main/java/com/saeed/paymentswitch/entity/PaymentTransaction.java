package com.saeed.paymentswitch.entity;

public interface PaymentTransaction extends CBOwner {
    String getTxId();
    String getOriginator();
    String getBeneficiary();
    Double getAmount();
}
