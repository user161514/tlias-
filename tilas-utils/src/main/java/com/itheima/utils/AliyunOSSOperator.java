package com.itheima.utils;

import com.aliyun.sdk.service.oss2.OSSClient;
import com.aliyun.sdk.service.oss2.credentials.StaticCredentialsProvider; // 注意这里是 Static
import com.aliyun.sdk.service.oss2.credentials.Credentials;
import com.aliyun.sdk.service.oss2.models.PutObjectRequest;
import com.aliyun.sdk.service.oss2.models.PutObjectResult;
import com.aliyun.sdk.service.oss2.transport.BinaryData;
import com.itheima.pojo.storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Primary
@Component
public class AliyunOSSOperator {

    @Autowired
    private storage m; // 确保你的 storage 类里包含 accessKeyId 和 accessKeySecret 字段，并且有 @ConfigurationProperties 和 @Data

    public AliyunOSSOperator() {
    }

    public String upload(byte[] content, String originalFilename) throws Exception {
        System.out.println("读取到的AK: [" + m.getAccessKeyId() + "]");
        System.out.println("读取到的SK: [" + m.getAccessKeySecret() + "]");
        String endpoint = m.getEndpoint();
        String bucketName = m.getBucketName();
        String region = m.getRegion();

        // ✅【修正点1】使用 StaticCredentialsProvider，从配置类里直接读取 AK/SK
        Credentials credentials = new Credentials(m.getAccessKeyId(), m.getAccessKeySecret());
        StaticCredentialsProvider credentialsProvider = new StaticCredentialsProvider(m.getAccessKeyId().trim(),m.getAccessKeySecret().trim());

        // 创建 OSS 客户端
        OSSClient ossClient = OSSClient.newBuilder()
                .endpoint(m.getEndpoint()) // endpoint 需确保是 oss-cn-beijing.aliyuncs.com，不带 http://
                .region(m.getRegion())     // region 需确保是 cn-beijing
                .credentialsProvider(credentialsProvider)
                .build();

        try {
            // 生成唯一文件名，防止重名覆盖
            String extension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            String objectName = "images/" + UUID.randomUUID() + extension;

            // 将 byte[] 包装为 BinaryData
            BinaryData binaryData = BinaryData.fromBytes(content);

            // 构建上传请求
            PutObjectRequest putObjectRequest = PutObjectRequest.newBuilder()
                    .bucket(bucketName)
                    .key(objectName)
                    .body(binaryData)
                    .build();

            // 执行上传
            PutObjectResult result = ossClient.putObject(putObjectRequest);

            // ✅【修正点2】返回文件的访问 URL（不要写死 oss-cn-beijing.aliyuncs.com，建议用 m.getUrlPrefix()）
            // 如果你之前的配置类里有 url-prefix，直接 m.getUrlPrefix() + objectName
            return "https://" + bucketName + ".oss-cn-beijing.aliyuncs.com/" + objectName;

        } finally {
            // 关闭客户端，释放资源（注意：生产环境建议把 OSSClient 声明为 Bean 单例，不要每次上传都 new 和 close）
            ossClient.close();
        }
    }

}