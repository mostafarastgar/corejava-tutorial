package com.saeed.paymentswitch.entity.cutoff;

public enum ParticipantRole {
    CREDITOR(1), NEUTRAL(0), DEBTOR(-1);
    private int value;

    ParticipantRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
