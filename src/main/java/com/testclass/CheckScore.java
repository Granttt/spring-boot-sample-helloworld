package com.testclass;

import com.example.utils.MyException;

import java.util.Scanner;

/**
 * @author gaoxi
 * @title: CheckScore
 * @projectName spring-boot-sample-helloworld
 * @description: TODO
 * @date 2020/04/13 15:09
 */
public class CheckScore {
    // 检查分数合法性的方法check() 如果定义的是运行时异常就不用抛异常了
    public void check(int score) throws MyException {// 抛出自己的异常类
        if (score > 120 || score < 0) {
            // 分数不合法时抛出异常
            throw new MyException("分数不合法，分数应该是0--120之间");// new一个自己的异常类
        } else {
            System.out.println("分数合法，你的分数是" + score);
        }
    }
}
class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        CheckScore check = new CheckScore();
        try {
            check.check(score);
        } catch (MyException e) {// 用自己的异常类来捕获异常
            e.printStackTrace();
        }
    }

}