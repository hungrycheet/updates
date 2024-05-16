package com.example.caching.cachingcaffeine.logconfig;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
public class RequestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse httpresponse = (HttpServletResponse)response;
		ContentCachingResponseWrapper contentcachingresponsewrapper = new ContentCachingResponseWrapper(httpresponse);
		chain.doFilter(request, contentcachingresponsewrapper);
		contentcachingresponsewrapper.copyBodyToResponse();
	}
	
	

}
