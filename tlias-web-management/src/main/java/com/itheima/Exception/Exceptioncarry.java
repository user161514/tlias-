package com.itheima.Exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class Exceptioncarry {
    @ExceptionHandler
    public Result handleException(Exception m){
        log.info("异常成功捕获！{}",m.getMessage());
        return Result.error(m.getMessage()); // Return a Result object with the error message
    }

}
