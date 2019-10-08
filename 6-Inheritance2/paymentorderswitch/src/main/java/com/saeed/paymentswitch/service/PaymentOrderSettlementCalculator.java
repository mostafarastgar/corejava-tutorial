package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentOrderSettlementCalculator<T extends PaymentTransaction> {
    private T[] paymentTransactions;

    public PaymentOrderSettlementCalculator(T[] paymentTransactions) {
        this.paymentTransactions = paymentTransactions;
    }

    public List<T> calculate(PaymentOrderSemanticValidator paymentOrderSemanticValidator) {
        List<T> paymentTransactionList = Arrays.stream(this.paymentTransactions).filter(item -> {
            if (paymentOrderSemanticValidator.validate(item)) {
                System.out.println(item);
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
//
//        ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
//        for (PaymentTransaction paymentTransaction : paymentTransactions) {
//            if (paymentOrderSemanticValidator.validate(paymentTransaction)) {
//                paymentTransactionList.add(paymentTransaction);
//                System.out.println(paymentTransaction);
//            }
//        }

        return paymentTransactionList;
    }
}
