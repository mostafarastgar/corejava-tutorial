package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this class can process payment transactions
 * @param <T> should implement PaymentTransaction type
 */
public abstract class PaymentOrderProcessor<T extends PaymentTransaction> {
    protected T[] paymentTransactions;

    /**
     * this method should convert raw payment orders from string to PaymentTransaction
     * @param rawPays are received from originator participants
     */
    public PaymentOrderProcessor(String[] rawPays) {
        initPaymentTransactions(rawPays);
    }

    protected abstract void initPaymentTransactions(String[] rawPays);

    public final void calculateStatements() {
        List<T> refinedPaymentOrderList = validateTransactions();
        refinedPaymentOrderList.parallelStream().forEach(item->settle(item));
        generateStatements(refinedPaymentOrderList);
    }

    /**
     * should validate the whole payment orders
     * @return valid payment orders
     */
    private List<T> validateTransactions() {

        return Arrays.stream(paymentTransactions).parallel()
                .filter(item -> getPaymentOrderSemanticValidator().validate(item))
                .collect(Collectors.toList());
//        List<T> refinedPaymentOrder = Arrays.stream(paymentTransactions).parallel()
//                .filter(item -> {
//                    if (getPaymentOrderSemanticValidator().validate(item)) {
//                        settle(item);
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }).collect(Collectors.toList());
//        List<T> refinedPaymentOrder = new ArrayList<>();
//        PaymentOrderSemanticsValidator paymentOrderSemanticsValidator = getPaymentOrderSemanticValidator();
//        for (T paymentTransaction : paymentTransactions) {
//            if(paymentOrderSemanticsValidator.validate(paymentTransaction)){
//                refinedPaymentOrder.add(paymentTransaction);
//            }
//        }
//        return refinedPaymentOrder;
    }

    /**
     * this method should settle payment orders
     * <b>this method should be thread safe</b>
     * @param item should be settled
     */
    protected abstract void settle(T item);

    protected abstract void generateStatements(List<T> refinedPaymentOrder);

    protected abstract PaymentOrderSemanticsValidator getPaymentOrderSemanticValidator();
}
