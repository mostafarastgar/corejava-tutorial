package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentOrderOrder004;
import com.saeed.paymentswitch.entity.PaymentTransaction;

public class PaymentOrder004Processor {
    private PaymentOrderOrder004[] paymentOrderOrder004s;

    public PaymentOrder004Processor(String[] rawPays) {
        // TODO: 9/21/2019 convert rawPays to 008 Payment Order
        paymentOrderOrder004s = new PaymentOrderOrder004[5];
        for (int i = 0; i < paymentOrderOrder004s.length; i++) {
            paymentOrderOrder004s[i] = new PaymentOrderOrder004("tx" + i, "bank1", "bank2", Double.valueOf(5 * i), "tx" + i);
        }
    }

    public void calculateStatements() {
        PaymentOrderSettlementCalculator paymentOrderSettlementCalculator = new PaymentOrderSettlementCalculator(paymentOrderOrder004s);
        PaymentTransaction[] refinedPaymentOrder = paymentOrderSettlementCalculator.calculate(paymentTransaction -> {
            // TODO: 9/21/2019 change banks balance
            return true;
        });
        generateStatements(refinedPaymentOrder);
    }

    private void generateStatements(PaymentTransaction[] refinedPaymentOrder) {

    }
}
