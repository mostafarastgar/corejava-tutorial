package com.saeed.payments;

public class MainClass {
    public static void main(String[] args) {
//        PaymentOrder py = new PaymentOrder("10");
        PaymentTransaction pt1 = new PaymentOrderOrder008("20");

        PaymentTransaction pt2 = new PaymentOrderOrder004("30", "20");


        InternationalPaymentOrder ipo = new InternationalPaymentOrder("40");

        processPaymentTransaction(ipo);



    }

    public static void processPaymentTransaction(PaymentTransaction pt){
        // TODO: 8/27/2019 pre process
        if(pt.settle()){
            System.out.println("transaction from " + pt.getOwner() +" was settled");
        }
        // TODO: 8/27/2019 post process
    }
}
