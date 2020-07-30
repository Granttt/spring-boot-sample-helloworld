package com.example.questions;

/**
 * @author GXY
 * @Package com.example.questions
 * @date 2020/7/21 11:51
 * @Copyright © 2020-2021 新流通
 * @Description:String.format()的详细用法
 * https://www.cnblogs.com/zhuyeshen/p/11435209.html
 */
public class StringFormat {
    public static void main(String[] args) {
        int a = 0;
        for (int i =0; i<=10;i++){
//            System.out.println( String.format("Hi,%d", i));
            if (i >a){
                a = i;
                System.out.println(a);
            }
        }
    }
}
