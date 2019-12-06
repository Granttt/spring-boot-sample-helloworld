package com.example;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author: gxy
 * @CreateDate: 2019/11/9 10:57
 * @Description:java 计算当前时间离月底有多少天
 * https://blog.csdn.net/u011598529/article/details/30711557?locationNum=12
 */
public class CalendarDate {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int d = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int now = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("今天距离月底还有:"+(d - now)+"天");

        int year = c.get(Calendar.YEAR) ;  //获取年份

        int month = c.get(Calendar.MONTH); //获取当前月份,0表示1月份

        int day = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        int first = c.getActualMinimum(c.DAY_OF_MONTH);    //获取本月最小天数
        int last = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数
        int time = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        int min = c.get(Calendar.MINUTE);          //获取当前分钟
        int xx = c.get(Calendar.SECOND);          //获取当前秒
        System.out.println(day);
        System.out.println(getRemainSecondsOneDay(new Date()));
        Date oldDate1 = ds.parse("2011-05-12"); //这里时间可以自己定
        System.out.println(isSameDay(new Date(), DateUtils.addDays(new Date(),1)));
        System.out.println(isSameDay(new Date(), oldDate1));


        System.out.println("getFirstAndLastDayOfMonth:"+getFirstAndLastDayOfMonth());

        System.out.println(getZeroTime(-1));

        System.out.println("zdd".equals("zdd"));


    }
    /**
     * 获取当前时间或指定时间离一天结束剩余秒数
     * @return
     * https://blog.csdn.net/newCheng/article/details/79727132
     */
    public static Integer getRemainSecondsOneDay(Date currentDate) {
        Calendar midnight=Calendar.getInstance();
        midnight.setTime(currentDate);
        midnight.add(Calendar.DAY_OF_MONTH,1);
        midnight.set(Calendar.HOUR_OF_DAY,0);
        midnight.set(Calendar.MINUTE,0);
        midnight.set(Calendar.SECOND,0);
        midnight.set(Calendar.MILLISECOND,0);
        Integer seconds=(int)((midnight.getTime().getTime()-currentDate.getTime())/1000);
        return seconds;
    }
    /**
     * 判断两个日期是否为同一天
     *
     * @param d1 日期一
     * @param d2 日期二
     * @return 同一天true，不是同一天false
     */
    public static boolean isSameDay(Date d1, Date d2) {
        boolean result = false;
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
            result = true;
        }
        return result;
    }

    /**
     * Java获取给定日期的月初和月末（月底）两个日期
     * https://www.cnblogs.com/will-666/p/11378783.html
     * @return
     * @throws ParseException
     */
    public static String getFirstAndLastDayOfMonth() throws ParseException {
        //指定日期
        String date_str = "2019-02-15";

        Calendar cale = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        cale.setTime(formatter.parse(date_str));

        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String firstDayOfMonth = formatter.format(cale.getTime()); // 当月第一天 2019-02-01

        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        String lastDayOfMonth = formatter.format(cale.getTime()); // 当月最后一天 2019-02-28

        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String DayOfMonth = formatter.format(cale.getTime()); // 下个月第一天 2019-02-28

        return DayOfMonth;
    }

    /**
     *  day 当天0点时间
     *  0 今天
     *  1 明天
     *  -1 昨天
     *  -2 两天前
     *  -3  三天前
     */
    public static Date getZeroTime(int day){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}