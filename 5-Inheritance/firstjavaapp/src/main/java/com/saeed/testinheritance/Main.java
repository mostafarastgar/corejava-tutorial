package com.saeed.testinheritance;

public class Main {
    public static void main(String[] args) {
        SuperClass sc = new SubClass();
        SuperClass sc2 = new SubClass2();

        callPrintMethod(sc);
        callPrintMethod(sc2);
    }

    private static void callPrintMethod(SuperClass sc) {
        sc.aMethod();
        sc.printState();
//        ((SubClass)sc).bMethod();
//        ((SubClass2)sc).cMethod();
//        (Integer)sc
        if(sc instanceof SubClass){
            ((SubClass)sc).bMethod();
        } else if(sc instanceof SubClass2){
            ((SubClass2)sc).cMethod();
        }
        SuperClass.staticAMethod();
        SubClass.staticAMethod();
        SuperClass.printStaticState();
        SubClass.printStaticState();
    }
}
