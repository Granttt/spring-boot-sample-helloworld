package com.testclass;

import java.text.MessageFormat;

/**
 * @author GXY
 * @Package com.testclass
 * @date 2020/8/24 16:19
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class MessageFormatTest {

    public static void main(String[] args) {
        /**
         * MessageFormat.format()用法
         * https://www.cnblogs.com/appium/p/10329734.html#top
         */
        String pig = "{0}{1}{2}{3}{4}{5}{6}{7}{8}{9}{10}{11}{12}{13}{14}{15}{16}";
        Object[] array = new Object[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"};
        MessageFormat temp = new MessageFormat(pig);
        String format = temp.format(array);
        System.out.println(format);

        String value = MessageFormat.format("oh, {0} is 'a' pig", "ZhangSan");
        System.out.println(value); // 输出：oh, ZhangSan is a pig
        //给字母a加上单引号
        String message = "oh, {0} is ''a'' pig";
        Object[] array1 = new Object[]{"ZhangSan"};
        String value1 = MessageFormat.format(message, array1);
        System.out.println(value1);

        //
        String s = "oh, {0,number,#.#} is a pig";
        Object[] objects = new Object[]{new Double(3.1415926)};
        String v = MessageFormat.format(s,objects);
        System.out.println(v);
    }
}
