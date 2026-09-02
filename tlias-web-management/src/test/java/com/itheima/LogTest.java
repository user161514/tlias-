package com.itheima;
import cn.hutool.core.io.FileUtil;
import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.JwtUtils;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Instant;
@SpringBootTest
public class LogTest {
    private static final Logger log= LoggerFactory.getLogger(LogTest.class);
    @Autowired
    AliyunOSSOperator m;
     @Autowired

    @Test
    public void testLog() throws Throwable {
        Instant CalendarDate = null;
        final int sum = 0;
        int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
//        sum = Arrays.stream(nums).sum();
        log.debug("计算结果为：" + sum);
        log.info("计算结果为：" + sum); // Changed from log.debug("计算结果为：" + sum);
        log.info(  "结束计算..."); // Changed from System.out.println(CalendarDate.now() + "结束计算...");
        m.upload(FileUtil.readBytes(new File("C:\\Users\\MSI\\Pictures\\Screenshots\\屏幕截图 2026-08-03 044921.png")),"屏幕截图 2026-08-03 044921.png");


    }





}