package com.saeed.paymentswitch.entity.cutoff;

import java.util.HashMap;
import java.util.Map;

public class BNP {
    private Map<String, Map<String, BNPItem>> participants;

    public BNP() {
        this.participants = new HashMap<>();
    }

    public void addNewAmount(String bic1, String bic2, long amount, int multiplicator) {
        if (!participants.containsKey(bic1)) {
            participants.put(bic1, new HashMap<>());
        }
        if (!participants.get(bic1).containsKey(bic2)) {
            participants.get(bic1).put(bic2, new BNPItem(bic2));
        }
        participants.get(bic1).get(bic2).addAmount(amount * multiplicator);
    }

    public String generateBNP(String participant) {
        return "BNP for " + participant + "[" + participants.get(participant).entrySet().parallelStream().map(Map.Entry::getValue)
                .collect(StringBuilder::new, (s1, entry) -> s1.append(System.lineSeparator() + entry)
                        , (s1, s2) -> s1.append(s2)).toString() + "]";
    }
}
