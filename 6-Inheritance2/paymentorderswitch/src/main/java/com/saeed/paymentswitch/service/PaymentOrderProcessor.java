package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PaymentOrderProcessor<T extends PaymentTransaction> {
    protected T[] paymentTransactions;

    public PaymentOrderProcessor(String[] rawPays) {
        initPaymentTransactions(rawPays);
    }

    protected abstract void initPaymentTransactions(String[] rawPays);

    public final void calculateStatements() {
        List<T> refinedPaymentOrderList = validateTransactions();
        generateStatements(refinedPaymentOrderList);
    }

    private List<T> validateTransactions() {
        List<T> refinedPaymentOrder = Arrays.stream(paymentTransactions)
                .filter(item -> {
                    boolean validate = getPaymentOrderSemanticValidator().validate(item);
                    if (validate) {
                        settle(item);
                        return true;
                    } else {
                        return false;
                    }
                }).collect(Collectors.toList());
        return refinedPaymentOrder;
    }

    protected abstract void settle(T item);

    protected abstract void generateStatements(List<T> refinedPaymentOrder);

    protected abstract PaymentOrderSemanticValidator getPaymentOrderSemanticValidator();
}
