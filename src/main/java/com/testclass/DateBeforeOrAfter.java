package com.testclass;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GXY
 * @Package com.testclass
 * @date 2020/7/11 13:08
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class DateBeforeOrAfter {
    @SneakyThrows
    public static void main(String[] args) {
        /**
         *  before:d1.before(d2) 只有d1在d2之前才返回true  否则false 相当于 d1 < d2
         *   after: d1.after(d2) 只有d1在d2之后才返回true  否则false  相当于 d1 > d2
         *   这两个函数在不使用!(非运算符)的情况下且单独使用时  均不包含=的情况(如<= >=)
         *   除非对这两个函数足够了解 否则还是使用getTime()来进行时间的比较才更清晰明了
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sdf.parse("2019-5-27 12:58:21");
        Date d2 = sdf.parse("2019-5-28 12:58:21");
        System.out.println("d1=d2时,before函数:"+d1.before(d2));
        System.out.println("d1=d2时,after函数:"+d1.after(d2));
//        d1 = sdf.parse("2019-5-28");
//        d2 = sdf.parse("2019-5-29");
//        System.out.println("d1<d2时,before函数:"+d1.before(d2));
//        System.out.println("d1<d2时,after函数:"+d1.after(d2));
//        d1 = sdf.parse("2019-5-28");
//        d2 = sdf.parse("2019-5-27");
//        System.out.println("d1>d2时,before函数:"+d1.before(d2));
//        System.out.println("d1>d2时,after函数:"+d1.after(d2));


//        Date a = new Date();
//        Date c = new Date(1990, 5, 29);
//        System.out.println("a.before(c)-->" + a.before(c));
//        System.out.println("a.after(c)-->" + a.after(c));
//        System.out.println("c.before(a)-->" + c.before(a));
//        System.out.println("c.after(a)-->" + c.after(a));
    }
}
