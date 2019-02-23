package com.huiketong.catshopkeeper.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 必须添加@Configuration注解
 */
//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    //addPathPattern后跟拦截地址，excludePathPatterns后跟排除拦截地址
     //  registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/loginHtml","/login/loginCheck","/error/500","/error/400","/hplus/**");;
    }


}
