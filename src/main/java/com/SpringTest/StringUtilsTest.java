package com.SpringTest;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * @author GXY
 * @Package com.SpringTest
 * @date 2020/8/29 14:28
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class StringUtilsTest {

    public static void main(String[] args) {
        //（1）字符串首字母大小写转换
        System.out.println(StringUtils.capitalize(null));
        System.out.println(StringUtils.capitalize("china"));
        System.out.println(StringUtils.uncapitalize(null));
        System.out.println(StringUtils.uncapitalize("CHINA"));
        //（2）字符串整体大小写转换
        System.out.println(StringUtils.lowerCase("ORG.APACHE.COMMONS.LANG3.STRINGUTILS中的STRINGUTILS常用方法", Locale.ENGLISH));//(按照指定转换规则转换为小写)
        //（4）判断字符串是否全部是大写或小写(空或空白符均为false)
        System.out.println("（4）判断字符串是否全部是大写或小写(空或空白符均为false)");
        System.out.println(StringUtils.isAllUpperCase("CHINA"));
        System.out.println(StringUtils.isAllUpperCase("CHINa"));
        System.out.println(StringUtils.isAllLowerCase("china"));
        System.out.println(StringUtils.isAllLowerCase("chIna"));
        System.out.println("（5）移除空白字符");
        System.out.println(StringUtils.deleteWhitespace(" c h  i\tn\ra"));
    }
}
