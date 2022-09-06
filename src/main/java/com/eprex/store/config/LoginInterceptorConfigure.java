package com.eprex.store.config;

import com.eprex.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LoginInterceptorConfigure
 * @Description TODO
 * @Author mi
 * @Date 31/8/2022 下午3:35
 * @Version 1.0
 **/

//拦截器的注册 使用的是webmvc配置类
@Configuration  //加载当前的拦截器进行注册
public class LoginInterceptorConfigure implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置白名单 /**表示全部拦截或者放行
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/login.html");
        patterns.add("/web/register.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        //拦截器的注册
        //excludePathPatterns  放行哪些 , addPathPatterns("/**") 拦截全部
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
