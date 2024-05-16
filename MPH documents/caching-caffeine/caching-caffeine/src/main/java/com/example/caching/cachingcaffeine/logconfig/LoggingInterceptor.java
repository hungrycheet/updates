//package com.example.caching.cachingcaffeine.logconfig;
//
//import java.nio.charset.StandardCharsets;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//
//@Component
//public class LoggingInterceptor implements HandlerInterceptor{
//	
//	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);
//	
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object object) throws Exception {
//		String handlerMethod = ((object instanceof HandlerMethod)) ? ((HandlerMethod)object).getMethod().toString() : "";
//		LOGGER.info("Received request, URL="+request.getRequestURI() + ", Method="+request.getMethod() + ", HandlerMethod = " + handlerMethod);
//		return true;
//	}
//	
//	
//	@Override
//	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object object, Exception ex)throws Exception {
//		
//		String handlerMethod = ((object instanceof HandlerMethod)) ? ((HandlerMethod)object).getMethod().toString() : "";
//		if(ex != null) {
//			LOGGER.error("Error occured while executing the service method. URL="+request.getRequestURI() + ", Exception=" + ex.getMessage() + ", Method="+request.getMethod() + ", HandlerMethod = " + handlerMethod + ", responseCode=" + response.getStatus());
//		} else {
//			LOGGER.info("Request is completed, URL="+request.getRequestURI() + ", Method="+request.getMethod() + ", HandlerMethod = " + handlerMethod + ", responseCode=" + response.getStatus());			
//		}
//
//	}
//}
