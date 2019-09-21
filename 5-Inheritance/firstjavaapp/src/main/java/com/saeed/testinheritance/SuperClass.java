package com.saeed.testinheritance;

public class SuperClass {
    int state;
    static int staticState=15;

    public static void staticAMethod(){
        System.out.println("static a method from super class");
    }
    public void aMethod(){
        System.out.println("from super class");
    }

    public static void printStaticState(){
        System.out.println("static state is " + staticState);

    }

    public void printState(){
        System.out.println("state is " + state);
    }
}
