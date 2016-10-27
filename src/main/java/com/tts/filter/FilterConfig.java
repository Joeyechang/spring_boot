package com.tts.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by : phoenix
 * Create Date: 2016/10/27
 */
@Configuration
public class FilterConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionTimeoutInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
