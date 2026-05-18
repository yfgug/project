package com.experiment.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect 
@Component
public class StudentAspect {

    @Pointcut("execution(* com.experiment.aop.StudentServiceImpl.*(..))")
    public void studentPointcut() {}

    // 前置通知：在目标方法执行前调用
    @Before("studentPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("【前置通知-日志记录】正在准备调用方法: " + joinPoint.getSignature().getName()); // 日志记录功能
    }

    // 后置通知：在目标方法执行后调用
    @After("studentPointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("【后置通知-日志记录】方法调用完毕: " + joinPoint.getSignature().getName()); // 日志记录功能
        System.out.println("-------------------------------------------------");
    }
}