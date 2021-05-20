package com.ua.config;

import com.ua.handlers.AccessHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AccessConfig implements WebMvcConfigurer {

    private final AccessHandlerInterceptor accessHandlerInterceptor;

    public AccessConfig(AccessHandlerInterceptor accessHandlerInterceptor) {
        this.accessHandlerInterceptor = accessHandlerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessHandlerInterceptor).addPathPatterns("/library");
    }
}
