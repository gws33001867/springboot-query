package com.example.springboottest.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;
    @Autowired
    private CorsInterceptor corsInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //跨域拦截器
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");

        //添加拦截器，配置拦截地址
        registry.addInterceptor(authenticationInterceptor)
        .addPathPatterns("/delete/**")
        .addPathPatterns("/insert/**")
        .addPathPatterns("/update/**");


    }
}



















