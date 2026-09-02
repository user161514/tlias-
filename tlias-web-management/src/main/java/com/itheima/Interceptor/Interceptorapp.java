package com.itheima.Interceptor;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
@Slf4j
public class Interceptorapp implements HandlerInterceptor {
    @Override //目标资源方法执行前执行，放回true：放行，返回false：不放行，🐕相当于Filter中的doFilter()
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String requestURI = req.getRequestURI();
        String header = req.getHeader("token");
        if (header != null) {
            try {
                JwtUtils.parseJwt(header);
                return true;
            } catch (Exception e) {
                log.info("令牌解析失败");
                resp.setStatus(401);
                return false;
            }

        } else {
            log.info("令牌为空!!!");
            resp.setStatus(401);
            return false;
        }

    }

    @Override //目标资源方法执行后执行，🐕相当于Filter中的destory()
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView mv) throws Exception {
        System.out.println("preHandle...");
    }

    @Override //视图渲染完毕后执行，最后执行--------------🐖早期前后端不分离的时候用的，现在很少用了
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
