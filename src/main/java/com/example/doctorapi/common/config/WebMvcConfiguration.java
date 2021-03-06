package com.example.doctorapi.common.config;

import com.example.doctorapi.handler.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/home**", "/configurePathMatch");
//                .excludePathPatterns("/user/**", "/configurePathMatch")
//                .excludePathPatterns("/swagger-ui.html", "/configurePathMatch");
    }
}
