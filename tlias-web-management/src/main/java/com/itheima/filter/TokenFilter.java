package com.itheima.filter;

import com.itheima.utils.CurrentHolder;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest response1 = (HttpServletRequest) request;
        String requestURI = response1.getRequestURI();
        HttpServletResponse response2 = (HttpServletResponse) response;
        if(requestURI.contains("/login"))
        {
            if(response1.getHeader("token") != null)
            { String token = response1.getHeader("token");
            Integer id = (Integer)JwtUtils.parseJwt(token).get("Id");
            CurrentHolder.setCurrentId(id);}
            System.out.println("================================================放行！！=================================================================");
            chain.doFilter(request,response);
            return;
        }
        else
        {
            String token = response1.getHeader("token");
            if(token == null||token.isEmpty())
            {
                log.info("令牌为空，响应401");
                response2.setStatus(401);
                return;
            }
            try {
                JwtUtils.parseJwt(token);
            } catch (Exception e) {
                log.info("令牌为空，响应401");
                response2.setStatus(401);
                return;
            }
            log.info("================================================放行！！=================================================================");
            Integer id = JwtUtils.parseJwt(token).get("Id",Integer.class);
            CurrentHolder.setCurrentId(id);
            chain.doFilter(request,response);
        }
    }
}
