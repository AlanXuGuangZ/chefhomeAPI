package com.example.chefhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ChefHomeApplication extends SpringBootServletInitializer {
    //部署到tomcat用
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //返回main方法中执行的ChefHomeApplication启动类
        return builder.sources(ChefHomeApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ChefHomeApplication.class,args);
    }
}
