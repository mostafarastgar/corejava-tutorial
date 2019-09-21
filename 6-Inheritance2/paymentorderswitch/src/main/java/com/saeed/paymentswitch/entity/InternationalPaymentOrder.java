package com.saeed.paymentswitch.entity;

public class InternationalPaymentOrder extends PaymentOrder {
    private String internationalId;

    public InternationalPaymentOrder(String internationalId, String txId, String originator, String beneficiary, Double amount) {
        super(txId, originator, beneficiary, amount);
        this.internationalId = internationalId;
    }

    @Override
    public void setTxId(String txId) {
        super.setTxId("int-" + internationalId + "-" + txId);
    }

    @Override
    public String getOwner() {
        return internationalId;
    }

    @Override
    protected String getPaymentOrderType() {
        return "int-008";
    }
}
