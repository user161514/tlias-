package com.itheima.Controller;

import com.itheima.Service.Emp22service;
import com.itheima.pojo.Emp22;
import com.itheima.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Emp22")
public class Emp22Controller {

    @Autowired
    Emp22service y;
    @GetMapping("/list")
    public Result emp22List(Emp22 list){
        List<Emp22> select = y.select(list);
        return Result.success(select);
    }
}
