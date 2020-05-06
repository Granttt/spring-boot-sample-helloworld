//package com.example.domain.repository;
//
//import com.example.utils.MyException;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
///**
// * @author gaoxi
// * @title: ErrorLogAop
// * @projectName spring-boot-sample-helloworld
// * @description: 保存错误日志
// * @date 2020/04/13 14:58
// */
//@Slf4j
//@Aspect
//@Component
//public class ErrorLogAop {
//
//    //注解里的路径是自己的controller层
//    @Pointcut("execution(public * com.example.*Controller.*(..))")
//    public void logPointcut() {
//    }
//
//    @Around("logPointcut()")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        try {
//            //调用接口，return调用接口的返回值
//            System.out.println("日志拦截结果：");
//            log.info((String) proceedingJoinPoint.proceed());
//            return proceedingJoinPoint.proceed();
//        } catch (Exception e) {
//
//                //这里捕获系统异常，如空指针等
//                //接口名+“ ”+错误信息
//                System.out.println(e.getStackTrace()[3].toString() + " " + e.getMessage());
//        }
//        return null;
//    }
//}