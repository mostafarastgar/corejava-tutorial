package com.saeed.paymentswitch.entity.cutoff;

import com.saeed.paymentswitch.entity.PaymentOrder;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StatementFile {
    public static final int STATEMENT_SIZE = 6;
    private String filename;
    private String participant;
    private LocalDateTime createDate;
    private List<Statement> statementList;

    public StatementFile(String filename, String participant) {
        this.filename = filename;
        this.participant = participant;
        this.createDate = LocalDateTime.now();
//        statementList = new ArrayList<>();
        this.statementList = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementFile that = (StatementFile) o;
        return filename.equals(that.filename) &&
                participant.equals(that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, participant);
    }

    public void addStatement(PaymentOrder order, BNP bnp) throws IllegalStatementSizeException {
        if(getStatementsSize()>= STATEMENT_SIZE){
            throw new IllegalStatementSizeException("statement size is greater than maximum allowed statements size ("+STATEMENT_SIZE+")");
        }
        statementList.add(new Statement(order.getOriginator(), order.getBeneficiary(), order.getAmount(), order.getPaymentOrderType()));
        if(participant.equals(order.getOriginator())){
            bnp.addNewAmount(participant, order.getBeneficiary(), order.getAmount(), -1);
        } else {
            bnp.addNewAmount(participant, order.getOriginator(), order.getAmount(), 1);
        }

    }

    public int getStatementsSize(){
        return statementList.size();
    }

    public String getFilename() {
        return filename;
    }

    public String getParticipant() {
        return participant;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public List<String> getStatementsString(){
        return this.statementList.parallelStream().map(Statement::toString)
                .collect(LinkedList::new, (list, statement)->list.add(statement), (list1, list2)->list1.addAll(list2));
    }

    @Override
    public String toString() {
        return "StatementFile{" +
                "filename='" + filename + '\'' +
                ", participant='" + participant + '\'' +
                ", size=" + getStatementsSize() +
                ", totalAmount=" + getTotalAmount() +
//                ", statements={" + statementList.parallelStream().map(Statement::toString).collect(StringBuilder::new,
//                (s1, s2)->s1.append(System.lineSeparator() + s2), (s1, s2)->s1.append(s2)) + "}" +
                ", statements={" + getStatementsString().stream().collect(StringBuilder::new,
                (s1, s2)->s1.append(System.lineSeparator() + s2), (s1, s2)->s1.append(s2)) + "}" +
                '}';
    }

    private long getTotalAmount() {
        long creditorSum = statementList.parallelStream().filter(item->item.getBeneficiaryBic().equals(participant)).mapToLong(Statement::getAmount).sum();
        long debtorSum = statementList.parallelStream().filter(item->item.getOriginatorBic().equals(participant)).mapToLong(Statement::getAmount).sum();
        return creditorSum - debtorSum;
    }
}
