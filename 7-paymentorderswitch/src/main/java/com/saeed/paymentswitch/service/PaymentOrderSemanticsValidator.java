package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

public interface PaymentOrderSemanticsValidator {
// SOLID
//    S Single Responsibility
//    O Open to extend close to modification
//    L Liskov
//    I Interface segregation
//    D Dependency Inversion
    boolean validate(PaymentTransaction pt);
}
