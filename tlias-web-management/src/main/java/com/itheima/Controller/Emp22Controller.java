package com.itheima.Controller;

import com.itheima.Service.Emp22service;
import com.itheima.pojo.Emp22;
import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@Slf4j
public class Emp22Controller {

    @Autowired
    Emp22service y;
    @GetMapping(value = "/dept1", produces = "application/json")
    public Result emp22List(){
        List<Emp22> select = y.select1();
        return Result.success(select);
    }

    @PostMapping(value = "/dept")
    public Result emp22Add(@RequestParam (name = "name") String name){
        y.emp22Add(name);
        log.info("添加员工信息：{}", name);
        return Result.success();
    }

    //给我一个根据id查询回显的
    @GetMapping(value = "/dept2/{id}")
    public Result emp22List1(@PathVariable Integer id){
        List<Emp22> select = y.select(id);
        log.info("根据id查询员工信息：{}", id);
        return Result.success(select);
    }
}


