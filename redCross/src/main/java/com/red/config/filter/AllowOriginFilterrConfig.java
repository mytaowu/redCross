package com.red.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: TMingYi
 * @date: 2020/5/5 11:44
 * springboot中注册一个跨域的
 */
@Configuration
public class AllowOriginFilterrConfig {
    @Bean
    public FilterRegistrationBean tulingFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AllowOriginFilter());
        //注意这里的路径，拦截器是/**，过滤器是/*
        filterRegistrationBean.addUrlPatterns("/*");
        return  filterRegistrationBean;
    }
}
