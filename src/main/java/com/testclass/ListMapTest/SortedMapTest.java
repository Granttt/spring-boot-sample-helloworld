package com.testclass.ListMapTest;


import sun.net.www.content.text.Generic;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author GXY
 * @Package com.testclass.ListMapTest
 * @date 2020/8/31 20:54
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class SortedMapTest {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("3", "33");
        map.put("1","11");
        map.put("2", "22");
        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println("排序之前:"+entry.getKey()+" 值"+entry.getValue());

        }
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + "\t" + next.getValue());
        }
        //Objects工具类来进行对象的equals比较,可以避免空指针
        System.out.println(Objects.equals("22","22"));

    }

    /**
     * 获取两个日期的时间差
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new RuntimeException("日期不能为空");
        }
        LocalDate localDate1 = date2LocalDate(date1);
        LocalDate localDate2 = date2LocalDate(date2);

        Long until = localDate1.until(localDate2, ChronoUnit.DAYS);
        return until.intValue();
//        // 这种方法是Java8特性
//        Generic.long2int(localDate1.until(localDate2, ChronoUnit.DAYS));
    }

    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }
}
