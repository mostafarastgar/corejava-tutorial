package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.InternationalPaymentOrder;
import com.saeed.paymentswitch.entity.PaymentTransaction;

public class EuropeanPaymentOrderProcessor {
    private InternationalPaymentOrder[] internationalPaymentOrders;

    public EuropeanPaymentOrderProcessor(String[] rawPays) {
        // TODO: 9/21/2019 convert rawPays to International Payment Order
        internationalPaymentOrders = new InternationalPaymentOrder[10];
        for (int i = 0; i < internationalPaymentOrders.length; i++) {
            internationalPaymentOrders[i] = new InternationalPaymentOrder("eur", "tx" + i, "bank1", "bank2", Double.valueOf(100 * i));
        }
    }

    public void transferPayments(){
        PaymentOrderSettlementCalculator paymentOrderSettlementCalculator = new PaymentOrderSettlementCalculator(internationalPaymentOrders);
        PaymentTransaction[] refinedPaymentOrder = paymentOrderSettlementCalculator.calculate(paymentTransaction -> {
            if(paymentTransaction.getAmount()<700){
                sendMessage(paymentTransaction);
                return true;
            } else {
                return false;
            }
        });
        calculateNewBalances(refinedPaymentOrder);
    }

    private void calculateNewBalances(PaymentTransaction[] refinedPaymentOrder) {

    }

    private void sendMessage(PaymentTransaction paymentTransaction) {
        // TODO: 9/21/2019 paymentTransaction should be sent via our messaging system
    }
}
