package com.eprex.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

@Configuration
@SpringBootApplication
@MapperScan("com.eprex.store.mapper") //指定Mapper接口 则无需在每个接口上写上@Mapper
public class StoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StoreApplication.class, args);
            System.out.println("               ----------run------ok-------------   ");
    }

    @Bean
    public MultipartConfigElement getMultipartConfigElement(){
        //使用工厂类
        MultipartConfigFactory factory =new MultipartConfigFactory();
        //设置大小
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        factory.setMaxRequestSize(DataSize.of(15,DataUnit.MEGABYTES));

        return factory.createMultipartConfig();
    }

}
