package com.huiketong.catshopkeeper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.huiketong.catshopkeeper.dao")
@EnableTransactionManagement
public class CatshopkeeperApplication implements WebMvcConfigurer {

    public static void main(String[] args) {

        SpringApplication.run(CatshopkeeperApplication.class, args);
    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/File/**")
//                .addResourceLocations("file:File/");
//    }

}

