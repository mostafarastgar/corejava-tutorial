package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

public interface PaymentOrderSettlement {
    boolean settle(PaymentTransaction pt);
}
