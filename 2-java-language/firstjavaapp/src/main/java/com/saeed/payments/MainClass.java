package com.saeed.payments;

public class MainClass {
    public static void main(String[] args) {
        PaymentTransaction pt1 = new PaymentOrderOrder008();

        PaymentTransaction pt2 = new PaymentOrderOrder004();




        processPaymentTransaction(pt2);
    }

    public static void processPaymentTransaction(PaymentTransaction pt){
        // TODO: 8/27/2019 pre process
        if(pt.settle()){
            System.out.println("transaction was settled");
        }
        // TODO: 8/27/2019 post process
    }
}
