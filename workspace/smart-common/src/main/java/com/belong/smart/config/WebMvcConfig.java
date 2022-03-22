package com.belong.smart.config;

import com.belong.smart.handler.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 注册自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor())
                // 拦截器拦截指定路径
                .addPathPatterns(
                        "/05_press/list3",
                        "/07_profile/**",
                        "/08_live/**",
                        "/09_hospital/userinfo/patient/**",
                        "/09_hospital/userinfo/types/list",
                        "/09_hospital/userinfo/order/**",
                        "/10_bus/userinfo/busOrders/**",
                        "/13_car_check/userinfo/apt/**",
                        "/13_car_check/userinfo/cars/**",
                        "/15_job/userinfo/deliver/**",
                        "/15_job/userinfo/resume/**",
                        "/16_move_car/**"
                );
    }
}
