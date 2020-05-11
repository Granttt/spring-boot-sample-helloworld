package com.example.utils;

import java.math.BigDecimal;

/**
 * @author gaoxi
 * @title: NumberUtil
 * @projectName api-server
 * @description: 使用Java将阿拉伯数字转换为中文数字（适配小数、负数转换）
 * @date 2020/04/25 13:40
 * https://www.cnblogs.com/chimmhuang/p/12675022.html
 */
public class NumberUtil {

    private NumberUtil() { }

    /**
     * 中文数字
     */
    private static final String[] CN_NUM = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    /**
     * 中文数字单位
     */
    private static final String[] CN_UNIT = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";

    /**
     * 特殊字符：点
     */
    private static final String CN_POINT = "点";


    /**
     * int 转 中文数字
     * 支持到int最大值
     *
     * @param intNum 要转换的整型数
     * @return 中文数字
     */
    public static String int2chineseNum(int intNum) {
        StringBuffer sb = new StringBuffer();
        boolean isNegative = false;
        if (intNum < 0) {
            isNegative = true;
            intNum *= -1;
        }
        int count = 0;
        while(intNum > 0) {
            sb.insert(0, CN_NUM[intNum % 10] + CN_UNIT[count]);
            intNum = intNum / 10;
            count++;
        }

        if (isNegative)
            sb.insert(0, CN_NEGATIVE);


        return sb.toString().replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "")
                .replaceAll("一十","十");
    }

    /**
     * bigDecimal 转 中文数字
     * 整数部分只支持到int的最大值
     *
     * @param bigDecimalNum 要转换的BigDecimal数
     * @return 中文数字
     */
    public static String bigDecimal2chineseNum(BigDecimal bigDecimalNum) {
        if (bigDecimalNum == null)
            return CN_NUM[0];

        StringBuffer sb = new StringBuffer();

        //将小数点后面的零给去除
        String numStr = bigDecimalNum.abs().stripTrailingZeros().toPlainString();

        String[] split = numStr.split("\\.");
        String integerStr = int2chineseNum(Integer.parseInt(split[0]));

        sb.append(integerStr);

        //如果传入的数有小数，则进行切割，将整数与小数部分分离
        if (split.length == 2) {
            //有小数部分
            sb.append(CN_POINT);
            String decimalStr = split[1];
            char[] chars = decimalStr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = Integer.parseInt(String.valueOf(chars[i]));
                sb.append(CN_NUM[index]);
            }
        }

        //判断传入数字为正数还是负数
        int signum = bigDecimalNum.signum();
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(int2chineseNum(10));
        System.out.println(bigDecimal2chineseNum(new BigDecimal(3.5)));
    }
}