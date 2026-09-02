package com.itheima.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix="aliyun.oss")
public class storage {
    String endpoint;
    String bucketName;
    String region ;
}
