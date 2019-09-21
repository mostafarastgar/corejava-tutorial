package com.saeed.paymentswitch;

import com.saeed.paymentswitch.service.EuropeanPaymentOrderProcessor;
import com.saeed.paymentswitch.service.PaymentOrder004Processor;
import com.saeed.paymentswitch.service.PaymentOrder008Processor;

public class Main {
    public static void main(String[] args) {
        PaymentOrder008Processor paymentOrder008Processor = new PaymentOrder008Processor(new String[]{""});
        paymentOrder008Processor.calculateStatements();

        PaymentOrder004Processor paymentOrder004Processor = new PaymentOrder004Processor(new String[]{""});
        paymentOrder004Processor.calculateStatements();

        EuropeanPaymentOrderProcessor europeanPaymentOrderProcessor = new EuropeanPaymentOrderProcessor(new String[]{""});
        europeanPaymentOrderProcessor.transferPayments();
    }
}
