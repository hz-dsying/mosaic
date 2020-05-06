package com.dsy.main.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebConfig {
	
	@Bean
    public Filter genresFilter() {
        return new GenresFilter();
    }
 
    @Bean
    public FilterRegistrationBean genresFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("genresFilter"));
        registration.addUrlPatterns("/toGenres");
        registration.setName("genresFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public Filter songDetailFilter() {
    	return new SongDetailFilter();
    }
    
    @Bean
    public FilterRegistrationBean songDetailFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("songDetailFilter"));
        registration.addUrlPatterns("/songDetail");
        registration.setName("songDetailFilter");
        registration.setOrder(1);
        return registration;
    }
    
    /*@Bean
    public Filter genericEncodingFilter() {
    	return new GenericEncodingFilter();
    }
    
    @Bean
    public FilterRegistrationBean genericEncodingFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("genericEncodingFilter"));
        registration.addUrlPatterns("/*");
        registration.setName("genericEncodingFilter");
        registration.setOrder(1);
        return registration;
    }*/
}
