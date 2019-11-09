package com.saeed.paymentswitch;

import com.saeed.paymentswitch.service.EuropeanPaymentOrderProcessor;
import com.saeed.paymentswitch.service.PaymentOrder004Processor;
import com.saeed.paymentswitch.service.PaymentOrder008Processor;
import com.saeed.paymentswitch.service.PaymentOrderProcessor;

public class Main {
    public static void main(String[] args) {
        PaymentOrderProcessor pop;
        pop = new PaymentOrder008Processor(new String[]{""});
        pop.processData(false);

        pop = new PaymentOrder004Processor(new String[]{""}, pop.getStatementFiles(), pop.getBnp());
        pop.processData(false);

        pop = new EuropeanPaymentOrderProcessor(new String[]{""}, pop.getStatementFiles(), pop.getBnp());
        pop.processData(true);
    }
}
