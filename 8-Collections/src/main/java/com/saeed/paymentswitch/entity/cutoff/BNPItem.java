package com.saeed.paymentswitch.entity.cutoff;

public class BNPItem {
    private String participant;
    private long amount;
    private ParticipantRole participantRole;

    public BNPItem(String participant) {
        this.participant = participant;
    }

    public void addAmount(long amount){
        this.amount += amount;
        if(this.amount>=ParticipantRole.CREDITOR.getValue()){
            this.participantRole = ParticipantRole.CREDITOR;
        } else if(this.amount<=ParticipantRole.DEBTOR.getValue()){
            this.participantRole = ParticipantRole.DEBTOR;
        } else {
            this.participantRole = ParticipantRole.NEUTRAL;
        }
    }

    public long getAmount() {
        return Math.abs(amount);
    }

    @Override
    public String toString() {
        return "BNPItem{" +
                "participant='" + participant + '\'' +
                ", amount=" + getAmount() +
                ", participantRole=" + participantRole +
                '}';
    }
}
