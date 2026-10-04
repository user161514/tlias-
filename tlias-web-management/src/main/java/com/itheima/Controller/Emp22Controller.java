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
    public Result emp22List() {
        List<Emp22> select = y.select1();
        return Result.success(select);
    }

    @PostMapping(value = "/dept")
    public Result emp22Add(@RequestParam(name = "name") String name) {
        y.emp22Add(name);
        log.info("添加员工信息：{}", name);
        return Result.success();
    }

    //给我一个根据id查询回显的
    @GetMapping(value = "/dept2/{id}")
    public Result emp22List1(@PathVariable Integer id) {
        List<Emp22> select = y.select(id);
        log.info("根据id查询员工信息：{}", id);
        return Result.success(select);
    }


    @PutMapping("/update")
    public Result emp22List10086(String name, Integer id) {
        log.info("修改员工信息：{}，{}", name, id);
        y.update(name, id);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result emp22List10086(@RequestBody Emp22 id) {
        log.info("删除员工信息：{}", id.getId());
        y.delete(id.getId());
        return Result.success();
    }

    @GetMapping("emp")
    public Result emp22List(Emp22 dj) {
        return Result.success(y.selectemp(dj));
    }

}


