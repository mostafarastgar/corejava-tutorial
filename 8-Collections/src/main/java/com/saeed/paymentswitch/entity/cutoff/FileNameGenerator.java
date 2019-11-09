package com.saeed.paymentswitch.entity.cutoff;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class FileNameGenerator {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static String generateNewFileName() {
        return LocalDate.now().toString() + atomicInteger.incrementAndGet();
    }
}
