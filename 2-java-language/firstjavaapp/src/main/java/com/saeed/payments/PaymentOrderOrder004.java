package com.saeed.payments;

public class PaymentOrderOrder004 extends PaymentOrder {
    private String orgTxId;
    public void insertIntoDB(){
//        todo: insert into db
    }

    @Override
    public boolean settle() {
        System.out.println("this is from 004");
        return super.settle();
    }
}
