package com.itheima.AOP;

import com.itheima.filter.TokenFilter;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.CurrentHolder;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

;
    // 拦截所有加了 @OperateLog 注解的方法
    @Around("@annotation(com.itheima.AOP.Login)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 1. 记录操作开始时间
        long begin = System.currentTimeMillis();
        System.out.println("记录操作开始时间");
        // 2. 执行目标方法
        Object result = joinPoint.proceed();
        System.out.println("执行目标方法");
        // 3. 记录操作结束时间
        long end = System.currentTimeMillis();

        // 4. 获取当前操作人 ID（知识点拓展：通常是存到 ThreadLocal 里的，这里模拟写死为 1）
        // 注意：如果你项目里还没有做登录拦截器存 ThreadLocal，这里先写个 1 测试即可。

        // 5. 构建日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(CurrentHolder.getCurrentId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        // 将方法参数数组转换成字符串（建议用 JSON 工具转，这里用 Arrays 简单演示）
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result.toString());
        operateLog.setCostTime(end - begin);

        // 6. 存入数据库
        try {
            operateLogMapper.insert(operateLog);
        } finally {
            CurrentHolder.remove();
        }

        log.info("AOP记录操作日志成功，耗时：{}ms", end - begin);

        // 7. 返回执行结果
        return result;
    }
}