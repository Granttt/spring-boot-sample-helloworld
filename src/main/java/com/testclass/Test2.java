package com.testclass;

@FunctionalInterface
interface MyInterface{
    void test();
    String toString();
}


/**
 * @author gaoxi
 * @title: Test2
 * @projectName spring-boot-sample-helloworld
 * @description: TODO
 * @date 2020/02/23/002311:24
 */
public class Test2 {
    public void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);

    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.myTest(() -> System.out.println("mytest"));

        new Thread(() -> {
            System.out.println("runnable");
        }).start();
    }
}