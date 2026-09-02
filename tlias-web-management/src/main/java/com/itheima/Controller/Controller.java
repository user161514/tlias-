//package com.itheima.Controller;
//
//import com.itheima.pojo.Result;
//import com.itheima.Service.serviceimpl.serviceimpl;
//import com.itheima.pojo.user;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//@Slf4j
//@RestController
//@RequestMapping("/dept")
//public class Controller {
//    @Autowired
//    private serviceimpl k;
//
//
//    @PostMapping
//    public Result respond(@RequestBody user m){
//        log.info("增加部门{}", m.getId());
//        k.insert(m);
//        return Result.success1();
//    }
//
//
//
//    @PutMapping
//    public Result respond1(@RequestBody user e){
//        log.info("修改数据成功{}", e.getId());
//        k.update(e);
//        return Result.success1();
//    }
//}
