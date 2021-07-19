package com.invokeTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author GXY
 * @Package com.invokeTest
 * @date 2020/10/22 15:45
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class ClazzTest {
    public static void main(String[] args) {
        try {
            Class cls=Class.forName("com.example.domain.ExceptionLog");

            //获取ExceptionLog类的所有方法信息
            System.out.println("获取ExceptionLog类的所有方法信息:");
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod.toString());
            }

            //获取ExceptionLog类的所有成员属性信息
            System.out.println("获取ExceptionLog类的所有成员属性信息");
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField.toString());
            }

            //获取ExceptionLog类的所有构造方法信息
            System.out.println("获取ExceptionLog类的所有构造方法信息");
            Constructor[] declaredConstructors = cls.getDeclaredConstructors();
            for (Constructor declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
