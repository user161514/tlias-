package com.itheima;

import com.itheima.AOP.OperateLogAspect;
import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.JwtUtils;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.annotation.DateTimeFormat;
@ServletComponentScan
@Import(com.itheima.Config.Test.class)
@SpringBootApplication
public class MangerTest {
    public static void main(String[] args) {
        SpringApplication.run(MangerTest.class, args);
    }

}
