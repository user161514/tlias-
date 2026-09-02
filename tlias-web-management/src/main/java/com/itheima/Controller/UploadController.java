package com.itheima.Controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@Slf4j
@RestController

    public class UploadController {
    @Autowired
    AliyunOSSOperator ee;

        @PostMapping("/url")
        public Result handleFileUpload(@RequestParam String name,
                                       @RequestParam Integer age,
                                       @RequestParam("file")
                                       MultipartFile file) throws Exception {
            log.info("文件上传: {}", file.getOriginalFilename());
            String upload = ee.upload(file.getBytes(), file.getOriginalFilename());
            log.info("文件上床url:{}",upload);
            // 处理文件...
            return Result.success(upload);

    }
}
