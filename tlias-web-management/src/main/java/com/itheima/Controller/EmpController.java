package com.itheima.Controller;

import com.itheima.AOP.Login;
import com.itheima.Service.Empservice;
import com.itheima.pojo.*;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.itheima.Exception.Exceptioncarry;
@RestController
@Slf4j
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private Empservice empservice;
    /**
     * 分页查询
     */

    @GetMapping("/list")
    public  Result page( emp1 k){
        log.info("分页查询: page={},pageSize={}",k.getPage(),k.getPageSize());
        PageResult<emp> limit = empservice.Limit(k);
        Result success = Result.success(limit);
        return success;
    }

    @PostMapping("/list1")
    public  Result save( @RequestBody emp k){
        log.info("新增员工, {}",k);
        empservice.save(k);
        return Result.success();
    }

    @DeleteMapping("/list2")
    public Result delete(@RequestParam("ids") List<Integer> ids){
        log.info("删除员工,{}", ids.toString());
        empservice.delete(ids);
        return Result.success();
    }
@Login
    @GetMapping("/list3/{id}")
    public Result selectall(@PathVariable Integer id){
        log.info("查询成功:{}",id);
    List<emp> e1=empservice.select(id);
        return Result.success(e1);
    }
    @PutMapping("/list4")
    public Result update(@RequestBody emp k){
        log.info("修改员工, {}",k);
        empservice.update(k);
        return Result.success();
    }
}
