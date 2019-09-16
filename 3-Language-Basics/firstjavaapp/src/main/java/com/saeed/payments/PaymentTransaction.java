package com.saeed.payments;

public interface PaymentTransaction extends GlobalPayments {
    boolean settle();
}
