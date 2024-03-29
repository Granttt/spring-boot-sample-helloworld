package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: gxy
 * @CreateDate: 2019/11/9 10:57
 * @Description:java 计算当前时间离月底有多少天
 * https://blog.csdn.net/u011598529/article/details/30711557?locationNum=12
 */
public class CalendarDate {
    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        int d = c.getActualMaximum(Calendar.DAY_OF_MONTH);
//        int now = c.get(Calendar.DAY_OF_MONTH);
//        System.out.println("今天距离月底还有:"+(d - now)+"天");
//
//        int year = c.get(Calendar.YEAR) ;  //获取年份
//
//        int month = c.get(Calendar.MONTH); //获取当前月份,0表示1月份
//
//        int day = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
//        int first = c.getActualMinimum(c.DAY_OF_MONTH);    //获取本月最小天数
//        int last = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数
//        int time = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
//        int min = c.get(Calendar.MINUTE);          //获取当前分钟
//        int xx = c.get(Calendar.SECOND);          //获取当前秒
//        System.out.println(day);
//        System.out.println(getRemainSecondsOneDay(new Date()));
//        Date oldDate1 = ds.parse("2011-05-12"); //这里时间可以自己定
//        System.out.println(isSameDay(new Date(), DateUtils.addDays(new Date(),1)));
//        System.out.println(isSameDay(new Date(), oldDate1));
//
//
//        System.out.println("getFirstAndLastDayOfMonth:"+getFirstAndLastDayOfMonth());
//
//        System.out.println(getZeroTime(-1));
//
//        System.out.println("zdd".equals("zdd"));

//        System.out.println("距离月底还有："+nowToMonth()+"天");
//        getTest();
//        getMonth();

        //初始化当前时间
//        Calendar calendar = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date begin = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date end = calendar.getTime();
        System.out.println(begin);
        System.out.println(end);

        addMinute(15);

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
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        //将毫秒至0
//        cale.set(Calendar.MILLISECOND, 0);
//        cale.add(Calendar.MILLISECOND, -1);
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
    /**
     * @Author: gxy
     * @Description:java获取当月第一天的零点零分和最后一天的23点59分
     * @Date: 2019/12/7 13:57
     * @return: void
     * https://blog.csdn.net/buxin_2008/article/details/77854190
     */
    public static void getFirstAndLastSecondOfMonth(){

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        //将秒至0
        calendar.set(Calendar.SECOND,0);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        //获得当前月第一天
        Date sdate = calendar.getTime();
        //将当前月加1；
        calendar.add(Calendar.MONTH, 1);
        //在当前月的下一月基础上减去1毫秒
        calendar.add(Calendar.MILLISECOND, -1);
        //获得当前月最后一天
        Date edate = calendar.getTime();

        System.out.println("The first day of month=="+sdate.toString());
        System.out.println("first day:"+sdate.getTime());
        System.out.println("The last day of month=="+edate.toString());

    }

    /**
     * 当前时间距月底还有几天
     * @return
     * getActualMaximum函数，主要是用于获取一个指定日期的当月总天数
     */
    public static Integer nowToMonth(){
        Calendar c = Calendar.getInstance();
        int d = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int now = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("本月月底是："+d+"号");
        System.out.println(now);

        return d -now;
    }
    public static void getTest(){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        /*获取今天的日期*/
        System.out.println("今天的日期是："+calendar.get(Calendar.DAY_OF_MONTH));
        /*获取十天之后的日期*/
//        calendar.clear();//避免继承当前系统的时间时间从1970-01-01开始，不清除则继承当前系统时间
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+2);
        System.out.println("十天之后的日期是："+calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static String getMonth(){
        Calendar cale = Calendar.getInstance();
//        Integer month=cale.get(Calendar.MONTH)+1;
//        System.out.println(month);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String demo = datechange(cale.getTime(), "yyyy_MM");
        System.out.println(demo);
        return null;
    }
    /**
     * 自定义日期格式化
     */
    public static String datechange(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String demo = sdf.format(date);
        return demo;
    }

    /**
     * 将时间加10分钟的方法
     */
    public static String addMinute(int minute) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, minute);
        System.out.println(sdf.format(nowTime.getTime()));

        //方法一：
        Date now = new Date();
        Date afterDate = new Date(now.getTime() + 600000);
        System.out.println(sdf.format(afterDate ));

        return sdf.format(nowTime.getTime());
    }

    /**
     * cal1.add(Calendar.DAY_OF_MONTH,1);
     * cal1.add(Calendar.DAY_OF_YEAR,1);
     * cal1.add(Calendar.DATE,1);
     *
     *
     * 就单纯的add操作结果都一样，因为都是将日期+1
     * 就没有区别说是在月的日期中加1还是年的日期中加1
     * 但是Calendar设置DAY_OF_MONTH和DAY_OF_YEAR的目的不是用来+1
     * 将日期加1，这通过cal1.add(Calendar.DATE,1)就可以实现
     * DAY_OF_MONTH的主要作用是cal.get(DAY_OF_MONTH)，用来获得这一天在是这个月的第多少天
     * Calendar.DAY_OF_YEAR的主要作用是cal.get(DAY_OF_YEAR)，用来获得这一天在是这个年的第多少天。
     * 同样，还有DAY_OF_WEEK，用来获得当前日期是一周的第几天
     *
     * https://blog.csdn.net/ruoxiyun/article/details/102840503
     */
}