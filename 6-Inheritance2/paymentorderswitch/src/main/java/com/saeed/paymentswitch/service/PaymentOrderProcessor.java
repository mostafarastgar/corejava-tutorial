package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

public abstract class PaymentOrderProcessor<T extends PaymentTransaction> {
    protected T[] paymentTransactions;

    public PaymentOrderProcessor(String[] rawPays) {
        initPaymentTransactions(rawPays);
    }

    protected abstract void initPaymentTransactions(String[] rawPays);

    public final void calculateStatements() {
        PaymentOrderSettlementCalculator paymentOrderSettlementCalculator = new PaymentOrderSettlementCalculator(paymentTransactions);
        PaymentTransaction[] refinedPaymentOrder = paymentOrderSettlementCalculator.calculate(getPaymentOrderSemanticValidator());
        generateStatements(refinedPaymentOrder);

    }

    protected abstract void generateStatements(PaymentTransaction[] refinedPaymentOrder);

    protected abstract PaymentOrderSemanticValidator getPaymentOrderSemanticValidator();
}
