package com.itheima.Controller;

import com.itheima.Service.ReportService;
import com.itheima.Service.serviceimpl.empservice;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.pojo.emp;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService o;
    @GetMapping("/list5")
    public Result selectall(){
        log.info("查询所有员工");
        JobOption e= o.getEmpJobData();
        return Result.success(e);
    }
    @GetMapping("/list6")
    public Result selectallgender(){

        List<Map<String, Object>> gender = o.getGender();
        log.info("查询员工性别占比,{}",gender);
        return Result.success(gender);
    }
}
