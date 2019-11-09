package com.saeed.paymentswitch.entity;

public interface CBOwner {
    default String getOwner() {
        return "CBI";
    }
}
