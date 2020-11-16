package com.itheima.shop.config;

import com.itheima.shop.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.mvc.MvcConfig
 ****/
@Component
public class MvcConfig implements WebMvcConfigurer{

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    /***
     * 拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).
                addPathPatterns("/**").
                excludePathPatterns("/user/login","/file/upload");
    }
}
