package com.example.cms.config;

import com.example.cms.filters.MyNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class MyFilterConfiguration {
    @Bean
    public FilterRegistrationBean<MyNewFilter> registrationBean() {
        FilterRegistrationBean<MyNewFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyNewFilter());
        registrationBean.addUrlPatterns("/customers/*");
        return registrationBean;
    }
}
