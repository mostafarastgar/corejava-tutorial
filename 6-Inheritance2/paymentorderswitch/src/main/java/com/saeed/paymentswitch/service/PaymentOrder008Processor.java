package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentOrderOrder008;
import com.saeed.paymentswitch.entity.PaymentTransaction;

public class PaymentOrder008Processor extends PaymentOrderProcessor<PaymentOrderOrder008> {

    public PaymentOrder008Processor(String[] rawPays) {
        super(rawPays);
    }

    @Override
    protected void initPaymentTransactions(String[] rawPays) {
        // TODO: 9/21/2019 convert rawPays to 008 Payment Order
        paymentTransactions = new PaymentOrderOrder008[10];
        for (int i = 0; i < paymentTransactions.length; i++) {
            paymentTransactions[i] = new PaymentOrderOrder008("tx" + i, "bank1", "bank2", Double.valueOf(10 * i));
        }
    }

    @Override
    protected PaymentOrderSemanticValidator getPaymentOrderSemanticValidator() {
        return paymentTransaction -> paymentTransaction.getAmount() < 60;
    }

    @Override
    protected void generateStatements(PaymentTransaction[] refinedPaymentOrder) {

    }
}
