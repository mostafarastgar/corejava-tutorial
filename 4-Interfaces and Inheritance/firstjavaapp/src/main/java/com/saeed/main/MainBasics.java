package com.saeed.main;

import com.saeed.payments.PaymentOrder;

import java.util.Arrays;

public class MainBasics {
    public static void main(String[] args) {
        int[] test = new int[20];
        int[] test1 = new int[]{10, 20, 11, 12};
        PaymentOrder[] pys = new PaymentOrder[10];
        System.out.println(test[1]);
        System.out.println(test1[1]);
        System.out.println(pys[1]);

        Arrays.sort(test1);
        System.out.println(test1[1]);
//        null pointer
//        System.out.println(pys[1].settle());


//        String is an immutable class
        String st = "10";
        String st2 = st.replace("1", "2");
        System.out.println(st);
        System.out.println(st2);

//        java 11 features
        String repeat = st.repeat(10);
        System.out.println(repeat);

        String test11 = " Hi Saeed ";

        System.out.println("result is:" + test11.strip() + ".");
        System.out.println("result is:" + test11.stripLeading() + ".");
        System.out.println("result is:" + test11.stripTrailing() + ".");

    }
}
