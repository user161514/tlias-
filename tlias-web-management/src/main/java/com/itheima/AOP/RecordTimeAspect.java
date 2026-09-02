//package com.itheima.AOP;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class RecordTimeAspect {
//    @Pointcut("@annotation(com.itheima.AOP.Login)")
//    public void pointcut() {
//    }
//    @Around("pointcut()")
//    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object proceed = pjp.proceed();
//        long end=System.currentTimeMillis();
//        log.info("方法执行耗时,：{} ms,方法名:{}", end - startTime,pjp.getSignature().getName());
//        return proceed;
//    }
//}
