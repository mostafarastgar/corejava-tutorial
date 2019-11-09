package com.saeed.paymentswitch.entity;

public class InternationalPaymentOrder extends PaymentOrder {
    private String internationalId;
    private static final String PREFIX = "int-";
    private static final String TYPE_008 = "int-008";

    public InternationalPaymentOrder(String internationalId, String txId, String originator, String beneficiary, Double amount) {
        super(txId, originator, beneficiary, amount);
        this.internationalId = internationalId;
    }

    @Override
    public void setTxId(String txId) {
        super.setTxId(PREFIX + internationalId + "-" + txId);
    }

    @Override
    public String getOwner() {
        return internationalId;
    }

    @Override
    protected String getPaymentOrderType() {
        return TYPE_008;
    }
}
