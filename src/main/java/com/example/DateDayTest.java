package com.example;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: gxy
 * @CreateDate: 2019/12/7 14:48
 * @Description:Java Calendar 计算两个时间相隔天数/秒数
 */
public class DateDayTest {
    public static void main(String[] args) throws ParseException {
        //定义时间格式年月日 时分秒
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1=sdf.parse("2017-10-25 5:20:30");
        Date d2=sdf.parse("2017-10-25 18:03:19");
        //方法一：日期格式的计算
        System.out.println(daysBetween(d1,d2));
        //方法二：字符串的日期格式的计算
        System.out.println(daysBetween("2014-09-15 5:20:30","2017-10-25 18:03:19"));
    }
    /**
     * 日期格式的计算
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     *字符串的日期格式的计算
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(String smdate,String bdate) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
}

/**
 * https://blog.csdn.net/weixin_44062339/article/details/113799915
 */
class LocalDateTimeTest {
    @SneakyThrows
    public static void main(String[] args) {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endOfDay = getEndOfDay(sdf.parse("2017-10-25 5:20:30"));
        System.out.println(JSON.toJSONString(endOfDay));
        test2();

    }

    /**
     * 获取日期的最后时间
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        //转成毫秒数
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    //通过long毫秒数创建LocaldateTime
    public static void test2() {
        //获取当前时间毫秒值
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        //创建Instant瞬时对象
        Instant instant = Instant.ofEpochMilli(currentTimeMillis);
        //获取默认时区即Asia/Shanghai
        ZoneId zone = ZoneId.systemDefault();//或ZoneId.of("Asia/Shanghai")
        //将long毫秒值转为LocalDateTime对象
        LocalDateTime ofInstant = LocalDateTime.ofInstant(instant, zone);
        System.out.println(ofInstant);
    }
}