package com.saeed.payments;

public class PaymentOrderOrder004 extends PaymentOrder {
    private String orgTxId;
    private String txId;

    public PaymentOrderOrder004(String txId, String orgTxId) {
        super(txId);
        int a = 10;
    }

    public void insertIntoDB(){
//        todo: insert into db
    }

    @Override
    public boolean settle() {
        this.txId = "004" + super.txId;
        System.out.println("this is from 004");
        return super.settle();
    }


}
