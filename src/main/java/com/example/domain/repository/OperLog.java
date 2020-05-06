package com.example.domain.repository;

import java.lang.annotation.*;

/**
 * @author gaoxi
 * @title: OperLog
 * @projectName spring-boot-sample-helloworld
 * @description: TODO 自定义操作日志注解
 * @date 2020/04/15 14:15
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface OperLog {
    String operModul() default ""; // 操作模块
    String operType() default "";  // 操作类型
    String operDesc() default "";  // 操作说明
}
