package com.example;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: gaoxi
 * @CreateDate: 2019/10/18 20:53
 * @Description:日期大小比较
 * https://www.cnblogs.com/telwanggs/p/11026505.html
 * getTime 返回毫秒数 即使没有毫秒位，用000填充
 * https://blog.csdn.net/u010523770/article/details/53068809/
 * BigDecimal用法
 */
public class DateCompare {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String beginTime=new String("2017-06-09 10:22:22");
        String endTime=new String("2017-05-08 11:22:22");
        Date nowDate = new Date();
        long long3 = nowDate.getTime();
        long long1 = df.parse(beginTime).getTime();
        long long2= df.parse(endTime).getTime();
        BigDecimal bigLoanAmount = new BigDecimal(long2/1000);
        //BigDecimal.ROUND_DOWN从不对舍弃部分前面的数字加1，即截短。 前面的数字代表保留几位小数，0则代表不保留
        BigDecimal a= new BigDecimal(long3/1000).setScale(0,BigDecimal.ROUND_DOWN);
        System.out.println(long1);
        System.out.println(long3);
        System.out.println(a);
        System.out.println(System.currentTimeMillis());

        System.out.println("=====================================================================");

        /**
         * date中compareTo的用法
         * https://blog.csdn.net/han_ying_ying/article/details/52161010
         * 相等返回0，大于返回1，小于返回-1.
         */
        Date oldDate1 = df.parse("2011-05-12 15:16:00"); //这里时间可以自己定
        Date oldDate2 = df.parse("2011-05-12 15:16:00"); //这里时间可以自己定
        System.out.println(oldDate1.compareTo(oldDate2)); //判断,如果时间在这时间后,就执行后面操作

    }
}