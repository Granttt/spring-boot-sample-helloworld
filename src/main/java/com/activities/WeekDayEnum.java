package com.activities;

import com.alibaba.fastjson.JSON;

/**
 * @author GXY
 * @Package com.activities
 * @date 2020/9/5 11:51
 * @Copyright © 2020-2021 新流通
 * @Description:
 * https://blog.csdn.net/labty/article/details/84914899
 * Java enum常见的用法
 * https://blog.csdn.net/echizao1839/article/details/80890490
 */
public enum WeekDayEnum {
    Mon, Tue, Wed, Thu, Fri, Sat, Sun
}

class enumTest{
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(WeekDayEnum.values()));
        System.out.println(WeekDayEnum.valueOf("Fri"));
        //ordinal的方法，这个方法返回枚举值在枚举类种的顺序，这个顺序根据枚举值声明的顺序而定
        System.out.println(WeekDayEnum.Wed.ordinal());
    }
}