package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentTransaction;

import java.util.ArrayList;

public class PaymentOrderSettlementCalculator {
    private PaymentTransaction[] paymentTransactions;

    public PaymentOrderSettlementCalculator(PaymentTransaction[] paymentTransactions) {
        this.paymentTransactions = paymentTransactions;
    }

    public PaymentTransaction[] calculate(PaymentOrderSettlement paymentOrderSettlement) {
        ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
        for (PaymentTransaction paymentTransaction : paymentTransactions) {
            if (paymentOrderSettlement.settle(paymentTransaction)) {
                paymentTransactionList.add(paymentTransaction);
                System.out.println(paymentTransaction);
            }
        }
        PaymentTransaction[] pys = new PaymentTransaction[0];
        return paymentTransactionList.toArray(pys);
    }
}
