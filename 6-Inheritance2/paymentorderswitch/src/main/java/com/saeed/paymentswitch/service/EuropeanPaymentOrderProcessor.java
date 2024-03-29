package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.InternationalPaymentOrder;
import com.saeed.paymentswitch.entity.PaymentTransaction;

import java.util.List;

public class EuropeanPaymentOrderProcessor extends PaymentOrderProcessor<InternationalPaymentOrder> {

    public EuropeanPaymentOrderProcessor(String[] rawPays) {
        super(rawPays);
    }

    @Override
    protected void initPaymentTransactions(String[] rawPays) {
        // TODO: 9/21/2019 convert rawPays to International Payment Order
        paymentTransactions = new InternationalPaymentOrder[10];
        for (int i = 0; i < paymentTransactions.length; i++) {
            paymentTransactions[i] = new InternationalPaymentOrder("eur", "tx" + i, "bank1", "bank2", Double.valueOf(100 * i));
        }
    }

    @Override
    protected PaymentOrderSemanticValidator getPaymentOrderSemanticValidator() {
        return paymentTransaction -> {
            if (paymentTransaction.getAmount() < 700) {
                calculateNewBalances((InternationalPaymentOrder) paymentTransaction);
                sendMessage(paymentTransaction);
                return true;
            } else {
                return false;
            }
        };
    }


    @Override
    protected void settle(InternationalPaymentOrder item) {
        System.out.printf("european payment order %s is settled%s", item, System.lineSeparator());

    }

    @Override
    protected void generateStatements(List<InternationalPaymentOrder> refinedPaymentOrder) {
        System.out.println("european statements are generated");
    }

    private void calculateNewBalances(InternationalPaymentOrder paymentOrder) {

    }

    private void sendMessage(PaymentTransaction paymentTransaction) {
        // TODO: 9/21/2019 paymentTransaction should be sent via our messaging system
    }
}
