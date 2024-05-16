//package com.example.caching.cachingcaffeine.logconfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class LoggingInterceptorConfiguration implements WebMvcConfigurer  {
//
//	    @Autowired
//	    private LoggingInterceptor logInterceptor;
//	 
//	    @Override
//	    public void addInterceptors(InterceptorRegistry registry) {
//	 
//	        registry.addInterceptor(logInterceptor);
//	    }
//}


//if you want to log only request and resposne urls and methods use Logging Interceptors.

//If you want to see request and resposnes urls along with body use Filters.