package com.demo;

/**
 * @author GXY
 * @Package com.demo
 * @date 2020/8/31 17:04
 * @Copyright © 2020-2021 新流通
 * @Description: Java switch case 语句
 * https://www.runoob.com/java/java-switch-case.html
 */
public class SwitchTest {
    public static void main(String[] args) {
        int a = 3;
        /**
         * (1)当变量的值与 case 语句的值相等时，那么 case 语句之后的语句开始执行，直到 break 语句出现才会跳出 switch 语句。
         *
         * 当遇到 break 语句时，switch 语句终止。程序跳转到 switch 语句后面的语句执行。case 语句不必须要包含 break 语句。
         * 如果没有 break 语句出现，程序会继续执行下一条 case 语句，直到出现 break 语句。
         * (2)如果 case 语句块中没有 break 语句时，匹配成功后，从当前 case 开始，后续所有 case 的值都会输出。
         */
        switch (a){
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            case 4:
                System.out.println("44");
            default:
                System.out.println("5");
        }
    }
}
