package com.saeed.paymentswitch.service;

import com.saeed.paymentswitch.entity.PaymentOrder;
import com.saeed.paymentswitch.entity.cutoff.BNP;
import com.saeed.paymentswitch.entity.cutoff.FileNameGenerator;
import com.saeed.paymentswitch.entity.cutoff.IllegalStatementSizeException;
import com.saeed.paymentswitch.entity.cutoff.StatementFile;

import java.util.*;
import java.util.stream.Collectors;

/**
 * this class can process payment transactions
 *
 * @param <T> should implement PaymentTransaction type
 */
public abstract class PaymentOrderProcessor<T extends PaymentOrder> {
    protected T[] paymentTransactions;
    private Map<String, Stack<StatementFile>> statementFiles;
    private BNP bnp;

    /**
     * this method should convert raw payment orders from string to PaymentTransaction
     *
     * @param rawPays are received from originator participants
     */
    public PaymentOrderProcessor(String[] rawPays) {
        initPaymentTransactions(rawPays);
        statementFiles = new HashMap<>();
        bnp = new BNP();
    }

    public PaymentOrderProcessor(String[] rawPays, Map<String, Stack<StatementFile>> statementFiles, BNP bnp) {
        initPaymentTransactions(rawPays);
        this.statementFiles = statementFiles;
        this.bnp = bnp;
    }

    protected abstract void initPaymentTransactions(String[] rawPays);

    public final void processData(boolean printCutoff) {
        List<T> refinedPaymentOrderList = validateTransactions();
//        our application is not thread safe
//        refinedPaymentOrderList.parallelStream().forEach(item -> settle(item));
        refinedPaymentOrderList.stream().forEach(item -> settle(item));
        if(printCutoff) {
            generateCutoffData();
        }
    }

    /**
     * should validate the whole payment orders
     *
     * @return valid payment orders
     */
    private List<T> validateTransactions() {

        return Arrays.stream(paymentTransactions).parallel()
                .filter(item -> getPaymentOrderSemanticValidator().validate(item))
                .collect(Collectors.toList());
//        List<T> refinedPaymentOrder = Arrays.stream(paymentTransactions).parallel()
//                .filter(item -> {
//                    if (getPaymentOrderSemanticValidator().validate(item)) {
//                        settle(item);
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }).collect(Collectors.toList());
//        List<T> refinedPaymentOrder = new ArrayList<>();
//        PaymentOrderSemanticsValidator paymentOrderSemanticsValidator = getPaymentOrderSemanticValidator();
//        for (T paymentTransaction : paymentTransactions) {
//            if(paymentOrderSemanticsValidator.validate(paymentTransaction)){
//                refinedPaymentOrder.add(paymentTransaction);
//            }
//        }
//        return refinedPaymentOrder;
    }

    /**
     * this method should settle payment orders
     * <b>this method should be thread safe</b>
     *
     * @param transaction should be settled
     */
    private void settle(T transaction) {
        createStatement(transaction.getOriginator(), transaction);
        createStatement(transaction.getBeneficiary(), transaction);
    }

    private void generateCutoffData() {
        for (Stack<StatementFile> statementFile : statementFiles.values()) {
//            while (!statementFile.isEmpty()) {
//                System.out.println(statementFile.pop());
//            }
            Set<StatementFile> statementFiles = statementFile.parallelStream().collect(Collectors.toSet());
            statementFiles.parallelStream().forEach(statementFile1 -> System.out.println(statementFile1));
        }
        for (String participant : statementFiles.keySet()) {
            System.out.println(bnp.generateBNP(participant));
        }
    }

    private void createStatement(String participant, T transaction) {
        if (!statementFiles.containsKey(participant)) {
            statementFiles.put(participant, new Stack<>() {{
                push(new StatementFile(FileNameGenerator.generateNewFileName(), participant));
            }});
        }
        try {
            statementFiles.get(participant).peek().addStatement(transaction, bnp);
        } catch (IllegalStatementSizeException e) {
            statementFiles.get(participant).push(new StatementFile(FileNameGenerator.generateNewFileName(), participant));
            try {
                statementFiles.get(participant).peek().addStatement(transaction, bnp);
            } catch (IllegalStatementSizeException ex) {
                throw new IllegalStateException("STATEMENT_SIZE should be greater than 0");
            }
        }
    }

    protected abstract PaymentOrderSemanticsValidator getPaymentOrderSemanticValidator();

    public Map<String, Stack<StatementFile>> getStatementFiles() {
        return statementFiles;
    }

    public BNP getBnp() {
        return bnp;
    }
}
