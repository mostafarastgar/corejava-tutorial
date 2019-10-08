package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentOrderOrder004;

import java.util.List;

public class PaymentOrder004Processor extends PaymentOrderProcessor<PaymentOrderOrder004> {

    public PaymentOrder004Processor(String[] rawPays) {
        super(rawPays);
    }

    @Override
    protected void initPaymentTransactions(String[] rawPays) {
        // TODO: 9/21/2019 convert rawPays to 008 Payment Order
        paymentTransactions = new PaymentOrderOrder004[5];
        for (int i = 0; i < paymentTransactions.length; i++) {
            paymentTransactions[i] = new PaymentOrderOrder004("tx" + i, "bank1", "bank2", Double.valueOf(5 * i), "tx" + i);
        }
    }

    @Override
    protected PaymentOrderSemanticValidator getPaymentOrderSemanticValidator() {
        return paymentTransaction -> {
            // TODO: 9/21/2019 change banks balance
            return true;
        };
    }

    @Override
    protected void settle(PaymentOrderOrder004 item) {
        System.out.printf("004 payment order %s is settled%s", item, System.lineSeparator());
    }

    @Override
    protected void generateStatements(List<PaymentOrderOrder004> refinedPaymentOrder) {
        System.out.println("004 statements are generated");
    }
}
