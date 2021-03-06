package com.example.questions;

/**
 * @Description:JAVA中的几种基本数据类型是什么，各自占用多少字节。
 * @Author: gaoxi
 * @CreateDate: 2019/9/4 15:41
 * @Version: 1.0
 * https://blog.csdn.net/zhangyubishoulin/article/details/82423177
 */
public class Question02 {
    public static void main(String[] args) {
        System.out.println (new StringBuilder ().append ("Byte-->>").append ("字节数：").append (Byte.BYTES).append (";位数：").
                append (Byte.SIZE).append ("; 最小值-->最大值:").append (Byte.MIN_VALUE).append ("-->").append (Byte.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Short-->>").append ("字节数：").append (Short.BYTES).append (";位数：").
                append (Short.SIZE).append ("; 最小值-->最大值:").append (Short.MIN_VALUE).append ("-->").append (Short.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Integer-->>").append ("字节数：").append (Integer.BYTES).append (";位数：").
                append (Integer.SIZE).append ("; 最小值-->最大值:").append (Integer.MIN_VALUE).append ("-->").append (Integer.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Long-->>").append ("字节数：").append (Long.BYTES).append (";位数：").
                append (Long.SIZE).append ("; 最小值-->最大值:").append (Long.MIN_VALUE).append ("-->").append (Long.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Float-->>").append ("字节数：").append (Float.BYTES).append (";位数：").
                append (Float.SIZE).append ("; 最小值-->最大值:").append (Float.MIN_VALUE).append ("-->").append (Float.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Double-->>").append ("字节数：").append (Double.BYTES).append (";位数：").
                append (Double.SIZE).append ("; 最小值-->最大值:").append (Double.MIN_VALUE).append ("-->").append (Double.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Character-->>").append ("字节数：").append (Character.BYTES).append (";位数：").
                append (Character.SIZE).append ("; 最小值-->最大值:").append ((int)Character.MIN_VALUE).append ("-->").append ((int)Character.MAX_VALUE));
    }

}