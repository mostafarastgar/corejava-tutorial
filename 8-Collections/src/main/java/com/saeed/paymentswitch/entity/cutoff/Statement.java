package com.saeed.paymentswitch.entity.cutoff;

public class Statement {
    private String originatorBic;
    private String beneficiaryBic;
    private long amount;
    private String type;

    public Statement(String originatorBic, String beneficiaryBic, long amount, String type) {
        this.originatorBic = originatorBic;
        this.beneficiaryBic = beneficiaryBic;
        this.amount = amount;
        this.type = type;
    }

    public String getOriginatorBic() {
        return originatorBic;
    }

    public String getBeneficiaryBic() {
        return beneficiaryBic;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "originatorBic='" + originatorBic + '\'' +
                ", beneficiaryBic='" + beneficiaryBic + '\'' +
                ", amount=" + amount + '\'' +
                ", type=" + type +
                '}';
    }
}
