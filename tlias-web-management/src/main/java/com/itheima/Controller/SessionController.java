package com.itheima.Controller;

import com.itheima.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class SessionController {
    @GetMapping("/s1")
    public Result session1(HttpSession session){
        log.info("HttpSession-s1: {}", session.hashCode());

        session.setAttribute("loginUser", "tom"); //往session中存储数据
        return Result.success();
    }

    @GetMapping("/s2")
    public Result session2(HttpSession session){
        log.info("HttpSession-s2: {}", session.hashCode());
        String id = session.getId();
        System.out.println("id是:"+id);
        Object loginUser = session.getAttribute("loginUser"); //从session中取数据
        log.info("loginUser: {}", loginUser);
        return Result.success(loginUser);
    }
}
