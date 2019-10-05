package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentOrderSettlementCalculator {
    private PaymentTransaction[] paymentTransactions;

    public PaymentOrderSettlementCalculator(PaymentTransaction[] paymentTransactions) {
        this.paymentTransactions = paymentTransactions;
    }

    public PaymentTransaction[] calculate(PaymentOrderSemanticValidator paymentOrderSemanticValidator) {
        List<PaymentTransaction> paymentTransactionList = Arrays.stream(this.paymentTransactions).filter(item -> {
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
        PaymentTransaction[] pys = new PaymentTransaction[0];
        return paymentTransactionList.toArray(pys);
    }
}
