package com.itheima.test;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin   // 注意：是字母 O，不是数字 0
@RestController
public class Controller {
    @RequestMapping(value = "/api/user", method = {RequestMethod.GET, RequestMethod.POST})
    public String a(HttpServletRequest e){
        System.out.println(e.getParameter("a"));
        return "我草泥马";
    }
}
