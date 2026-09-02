package com.itheima.Config;

import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Commond {
    @Bean
    AliyunOSSOperator aliyun(){
        return new AliyunOSSOperator();
    }
}
