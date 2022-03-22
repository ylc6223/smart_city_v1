package com.belong.blog.config;

import com.belong.blog.util.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("");
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw new RuntimeException("你还未登录，请先去登录");
        }

        // 校验token
        Boolean verifyToken = JwtUtils.verifyToken(token);
        if (!verifyToken) {
            throw new RuntimeException("token已失效，请你重新登录");
        }
        return true;
    }
}
