//package com.itheima.filter;
//
//import com.itheima.utils.JwtUtils;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
//@Slf4j
//public class AbcFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("init初始化的方法运行...");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//         log.info("拦截到了请求...");
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        log.info("destory销毁的方法运行...");
//    }
//}
