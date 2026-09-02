package com.itheima.utils;

import com.aliyun.sdk.service.oss2.OSSClient;
import com.aliyun.sdk.service.oss2.credentials.EnvironmentVariableCredentialsProvider;
import com.aliyun.sdk.service.oss2.models.PutObjectRequest;
import com.aliyun.sdk.service.oss2.models.PutObjectResult;
import com.aliyun.sdk.service.oss2.transport.BinaryData;
import com.itheima.pojo.storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;//github
@Primary
@Component

public class AliyunOSSOperator {
    @Autowired
    private  storage m;

    public AliyunOSSOperator() {
    }

    public String upload(byte[] content, String originalFilename) throws Exception {
         String endpoint = m.getEndpoint();
         String bucketName = m.getBucketName();
         String region = m.getRegion();


        // 从环境变量中获取访问凭证，运行本代码示例之前，请确保已设置环境变量 OSS_ACCESS_KEY_ID 和 OSS_ACCESS_KEY_SECRET
        EnvironmentVariableCredentialsProvider credentialsProvider = new EnvironmentVariableCredentialsProvider();

        // 创建 OSS 客户端
        OSSClient ossClient = OSSClient.newBuilder()
                .endpoint(m.getEndpoint())
                .region(m.getRegion())
                .credentialsProvider(credentialsProvider)
                .build();

        try {
            // 生成唯一文件名，防止重名覆盖
            String extension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            String objectName = "images/" + UUID.randomUUID() + extension;

            // 【修正点】将 byte[] 包装为 BinaryData
            BinaryData binaryData = BinaryData.fromBytes(content);

            // 构建上传请求
            PutObjectRequest putObjectRequest = PutObjectRequest.newBuilder()
                    .bucket(bucketName)
                    .key(objectName)
                    .body(binaryData)   // ← 这里传入 BinaryData
                    .build();

            // 执行上传
            PutObjectResult result = ossClient.putObject(putObjectRequest);

            // 返回文件的访问 URL
            return "https://" + bucketName + ".oss-cn-beijing.aliyuncs.com/" + objectName;

        } finally {
            // 关闭客户端，释放资源
            ossClient.close();
        }
    }
}