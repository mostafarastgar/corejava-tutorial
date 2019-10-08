package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentOrderOrder008;

import java.util.List;

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
    protected void settle(PaymentOrderOrder008 item) {
        System.out.printf("008 payment order %s is settled%s", item, System.lineSeparator());
    }

    @Override
    protected void generateStatements(List<PaymentOrderOrder008> refinedPaymentOrder) {
        System.out.println("008 statements are generated");
    }
}
