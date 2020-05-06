package com.example.domain.repository;

import com.alibaba.fastjson.JSON;
import com.example.domain.ExceptionLog;
import com.example.domain.OperationLog;
import com.example.service.OperationLogService;
import com.example.utils.IPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author gaoxi
 * @title: OperLogAspect
 * @projectName spring-boot-sample-helloworld
 * @description: TODO  切面处理类，操作日志异常日志记录处理
 * @date 2020/04/15 14:19
 */
@Aspect
@Component
public class OperLogAspect {
    /**
     * 操作版本号
     * <p>
     * 项目启动时从命令行传入，例如：java -jar xxx.war --version=201902
     * </p>
     */
    @Value("${version}")
    private String operVer;
    @Autowired
    private OperationLogService operationLogService;
    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.example.domain.repository.OperLog)")
    public void operLogPoinCut() {
    }
    /**
     * 设置操作异常切入点记录异常日志 扫描所有controller包下操作
     */
    @Pointcut("execution(* com.example..*.*(..))")
    public void operExceptionLogPoinCut() {
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "operLogPoinCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint,Object keys){
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        OperationLog operationLog = new OperationLog();
        operationLog.setOperId(String.valueOf(UUID.randomUUID()).replace("-","")); // 主键ID

        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        OperLog operLog = method.getAnnotation(OperLog.class);
        if (operLog != null){
            String operModul = operLog.operModul();
            String operType = operLog.operType();
            String operDesc = operLog.operDesc();
            operationLog.setOperModul(operModul); // 操作模块
            operationLog.setOperType(operType); // 操作类型
            operationLog.setOperDesc(operDesc); // 操作描述
        }
        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        methodName = className + "." + methodName;

        operationLog.setOperMethod(methodName); // 请求方法

        //请求的参数
        Map<String,String> rtnMap = converMap(request.getParameterMap());
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(rtnMap);
        operationLog.setOperRequParm(params); // 请求参数
        operationLog.setOperRespParm(JSON.toJSONString(keys)); // 返回结果
//        operationLog.setOperUserId(UserShiroUtil.getCurrentUserLoginName()); // 请求用户ID
//        operationLog.setOperUserName(UserShiroUtil.getCurrentUserName()); // 请求用户名称
        operationLog.setOperIp(IPUtil.getIpAddress(request)); // 请求IP
        operationLog.setOperUri(request.getRequestURI()); // 请求URI
        operationLog.setOperCreateTime(new Date()); // 创建时间
        operationLog.setOperVer(operVer); // 操作版本
        operationLogService.insert(operationLog);

    }

    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     *
     * @param joinPoint 切入点
     * @param e 异常信息
     */
    @AfterThrowing(pointcut = "operExceptionLogPoinCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e){
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取的RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        ExceptionLog excepLog = new ExceptionLog();

        try {
            //从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();
            excepLog.setExcId(UUID.randomUUID().toString().replace("-",""));
            //获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            //获取请求的方法名
            String methodName = method.getName();
            methodName = className + "."  + methodName;
            //请求的参数
            Map<String,String> rtnMap = converMap(request.getParameterMap());
            //将参数所在的数组转换成json
            String params = JSON.toJSONString(rtnMap);
            excepLog.setExcRequParam(params); // 请求参数
            excepLog.setOperMethod(methodName); // 请求方法名
            excepLog.setExcName(e.getClass().getName()); // 异常名称
            excepLog.setExcMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace())); // 异常信息
//            excepLog.setOperUserId(UserShiroUtil.getCurrentUserLoginName()); // 操作员ID
//            excepLog.setOperUserName(UserShiroUtil.getCurrentUserName()); // 操作员名称
            excepLog.setOperUri(request.getRequestURI()); // 操作URI
            excepLog.setOperIp(IPUtil.getRemortIP(request)); // 操作员IP
            excepLog.setOperVer(operVer); // 操作版本号
            excepLog.setOperCreateTime(new Date()); // 发生异常时间

            operationLogService.insertExc(excepLog);

        }catch (Exception e2){
            e2.printStackTrace();
        }


    }
    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String,String> converMap(Map<String,String[]> paramMap){
        Map<String, String> rtnMap = new HashMap<String, String>();
        for (String s : paramMap.keySet()) {
            rtnMap.put(s, paramMap.get(s)[0]);
        }
        return rtnMap;
    }

    /**
     * @Author: gxy
     * @Description:
     * @Date: 2020/04/16 16:41
     * @Param exceptionName:异常名称
     * @Param exceptionMessage:异常信息
     * @Param elements: 堆栈信息
     * @return: java.lang.String
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements){
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement element : elements) {
            stringBuffer.append(elements + "\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + stringBuffer.toString();
        return message;
    }
}