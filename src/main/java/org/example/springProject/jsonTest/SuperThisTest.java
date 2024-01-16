package org.example.springProject.jsonTest;

public class SuperThisTest  extends SuperClass {

    //public static void test() {
      //  System.out.println("child is called");
    //}

    public void test2() {
        System.out.println("Child method2 is called");
    }

    public void callAll() {
        super.test();
        test();
        this.test2();
    }

    public static void main(String args[]) {
        SuperThisTest test = new SuperThisTest();
        // test.callAll();
        SuperThisTest.test();
        SuperClass.test();
    }
}

class SuperClass {
    public static void test() {
        System.out.println("super is called");
    }
}