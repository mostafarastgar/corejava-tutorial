package com.saeed.payments;

public interface GlobalPayments {
    String getTxId();

//    String getOwner();

    default String getOwner() {
        return "CBI";
    }
}
