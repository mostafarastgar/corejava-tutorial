package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentOrder008;

import java.util.List;

public class PaymentOrder008Processor extends PaymentOrderProcessor<PaymentOrder008> {

    public PaymentOrder008Processor(String[] rawPays) {
        super(rawPays);
    }

    @Override
    protected void initPaymentTransactions(String[] rawPays) {
        // TODO: 9/21/2019 convert rawPays to 008 Payment Order
        paymentTransactions = new PaymentOrder008[10];
        for (int i = 0; i < paymentTransactions.length; i++) {
            paymentTransactions[i] = new PaymentOrder008("tx" + i, "bank1", "bank2", Double.valueOf(10 * i));
        }
    }

    @Override
    protected PaymentOrderSemanticsValidator getPaymentOrderSemanticValidator() {
        return (paymentTransaction) -> paymentTransaction.getAmount() < 80;
//        return new PaymentOrderSemanticsValidator() {
//            @Override
//            public boolean validate(PaymentTransaction pt) {
//                if(pt.getAmount()<80)
//                    return true;
//                else
//                    return false;
//            }
//        };
    }


    @Override
    protected void settle(PaymentOrder008 item) {
        System.out.printf("008 payment order %s is settled%s", item, System.lineSeparator());
    }

    @Override
    protected void generateStatements(List<PaymentOrder008> refinedPaymentOrder) {
        System.out.println("008 statements are generated");
    }
}
