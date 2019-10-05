package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

public interface PaymentOrderSemanticValidator {
    boolean validate(PaymentTransaction pt);
}
