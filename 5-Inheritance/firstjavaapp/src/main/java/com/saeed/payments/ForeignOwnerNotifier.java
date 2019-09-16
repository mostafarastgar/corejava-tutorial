package com.saeed.payments;

public interface ForeignOwnerNotifier {
    void notifyForeignCBI(PaymentTransaction[] pys);
}
