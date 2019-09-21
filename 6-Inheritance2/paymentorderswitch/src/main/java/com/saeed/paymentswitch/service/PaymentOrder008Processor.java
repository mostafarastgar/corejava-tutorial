package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentOrderOrder008;
import com.saeed.paymentswitch.entity.PaymentTransaction;

public class PaymentOrder008Processor {
    private PaymentOrderOrder008[] paymentOrderOrder008s;

    public PaymentOrder008Processor(String[] rawPays) {
        // TODO: 9/21/2019 convert rawPays to 008 Payment Order
        paymentOrderOrder008s = new PaymentOrderOrder008[10];
        for (int i = 0; i < paymentOrderOrder008s.length; i++) {
            paymentOrderOrder008s[i] = new PaymentOrderOrder008("tx" + i, "bank1", "bank2", Double.valueOf(10 * i));
        }
    }

    public void calculateStatements() {
        PaymentOrderSettlementCalculator paymentOrderSettlementCalculator = new PaymentOrderSettlementCalculator(paymentOrderOrder008s);
        PaymentTransaction[] refinedPaymentOrder = paymentOrderSettlementCalculator.calculate(paymentTransaction -> paymentTransaction.getAmount() < 60);
        generateStatements(refinedPaymentOrder);
    }

    private void generateStatements(PaymentTransaction[] refinedPaymentOrder) {

    }
}
