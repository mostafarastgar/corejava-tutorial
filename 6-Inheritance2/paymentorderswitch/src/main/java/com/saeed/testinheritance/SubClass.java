package com.saeed.testinheritance;

public class SubClass extends SuperClass {

    int state = 10;
    static int staticState = 20;

    public static void staticAMethod() {
        System.out.println("static a method from sub class");
    }

    public static void printStaticState() {
        System.out.println("static state is " + staticState);
    }

    @Override
    public void printState() {
        super.printState();
        System.out.println("state is " + super.state);
    }

    @Override
    public void aMethod() {
//        super.aMethod();
        System.out.println("sub class version of a method");
    }

    public void bMethod() {
        System.out.println("from sub class");
    }
}
