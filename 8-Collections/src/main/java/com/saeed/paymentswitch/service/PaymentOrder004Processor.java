package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentOrder004;
import com.saeed.paymentswitch.entity.cutoff.BNP;
import com.saeed.paymentswitch.entity.cutoff.StatementFile;

import java.util.Map;
import java.util.Stack;

public class PaymentOrder004Processor extends PaymentOrderProcessor<PaymentOrder004> {

    public PaymentOrder004Processor(String[] rawPays) {
        super(rawPays);
    }

    public PaymentOrder004Processor(String[] rawPays, Map<String, Stack<StatementFile>> statementFiles, BNP bnp) {
        super(rawPays, statementFiles, bnp);
    }

    @Override
    protected void initPaymentTransactions(String[] rawPays) {
        // TODO: 9/21/2019 convert rawPays to 008 Payment Order
        paymentTransactions = new PaymentOrder004[5];
        for (int i = 0; i < paymentTransactions.length; i++) {
            paymentTransactions[i] = new PaymentOrder004("tx" + i, "bank1", "bank2", Long.valueOf(5 * i), "tx" + i);
        }
    }

    @Override
    protected PaymentOrderSemanticsValidator getPaymentOrderSemanticValidator() {
        return paymentTransaction -> {
            // TODO: 9/21/2019 change banks balance
            return true;
        };
    }
}
