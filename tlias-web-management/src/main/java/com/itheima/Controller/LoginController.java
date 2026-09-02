package com.itheima.Controller;

import com.itheima.AOP.Login;
import com.itheima.Service.LoginService;
import com.itheima.pojo.Logininfo;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService d;
    @Login
    @GetMapping("/list")
    public Result login(@RequestBody Logininfo logininfo) {
        log.info("登录,{}", logininfo);
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        Logininfo login = d.Login(logininfo);
        if (login != null) {
            objectObjectHashMap.put("Id", login.getId());
            objectObjectHashMap.put("username", "松江");
            String token = JwtUtils.generateJwt(objectObjectHashMap);
            return Result.success(new Logininfo(login.getId(),login.getUsername(),login.getName(),token));
        } else
           return Result.error("登录失败");
    }
    @Login
    @GetMapping("/list2")
    public Result list2( HttpServletRequest token) {
        log.info("查询所有员工");
        String s = token.getHeader("token");
        Claims claims = JwtUtils.parseJwt(s);
        return Result.success(s);
    }
}
