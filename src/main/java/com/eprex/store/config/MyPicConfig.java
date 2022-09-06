package com.eprex.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyPicConfig
 * @Description TODO
 * @Author mi
 * @Date 2/9/2022 上午12:22
 * @Version 1.0
 **/
@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    //添加资源拦截器
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/src/main/resources/static/upload/");
        //file:D:/JAVAProgramm/com.eprex/src/main/resources/static/upload/
    }
}
