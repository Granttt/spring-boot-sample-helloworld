package com.testclass;

import java.util.Random;

/**
 * @author GXY
 * @Package com.testclass
 * @date 2020/8/31 10:10
 * @Copyright © 2020-2021 新流通
 * @Description:JAVA中Random();范围定义
 * https://blog.csdn.net/fengzyf/article/details/103388901
 */
public class RandomTest {
    public static void main(String[] args) {
        /**
         * java 使用Random产生规定区间内的随机数
         * 【Min, Max】= random(Max – Min +1) + Min 推导过程
         */
        Random r = new Random();
        //[0,max) 左开右闭
        int temp = r.nextInt(4)+5;

        System.out.println(temp);
    }
}
