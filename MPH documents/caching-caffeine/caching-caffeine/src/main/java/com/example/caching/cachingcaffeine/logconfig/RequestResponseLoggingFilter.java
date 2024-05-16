package com.example.caching.cachingcaffeine.logconfig;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RequestResponseLoggingFilter implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse)response;
		
		ContentCachingRequestWrapper contentcachingrequestwrapper = new ContentCachingRequestWrapper(httprequest);
		ContentCachingResponseWrapper contentcachingresponsewrapper = new ContentCachingResponseWrapper(httpresponse);
		
		chain.doFilter(contentcachingrequestwrapper, contentcachingresponsewrapper);
		
		logRequest(httprequest, contentcachingrequestwrapper);
		logResponse(httpresponse, contentcachingresponsewrapper);
		contentcachingresponsewrapper.copyBodyToResponse();
		
	}

	private void logRequest(HttpServletRequest httprequest, ContentCachingRequestWrapper contentcachingrequestwrapper) {
		// TODO Auto-generated method stub
		String requestBody = " ";
		if (contentcachingrequestwrapper != null && contentcachingrequestwrapper.getContentLength() > 0) {
			
			requestBody = new String(contentcachingrequestwrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
		}
		LOGGER.info("############################### REQUEST ##############################################");
		LOGGER.info("URI         : {}",  httprequest.getRequestURI());
		LOGGER.info("Method      : {}",  httprequest.getMethod());
		LOGGER.info("Request body: {}",  requestBody);
	}

	private void logResponse(HttpServletResponse httpresponse,	ContentCachingResponseWrapper contentcachingresponsewrapper) {
		// TODO Auto-generated method stub
		String responseBody = new String(contentcachingresponsewrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
		
		LOGGER.info("############################### RESPONSE #############################################");
		LOGGER.info("Status code  : {}", httpresponse.getStatus());
		LOGGER.info("Response body: {}", responseBody);
	}
}
