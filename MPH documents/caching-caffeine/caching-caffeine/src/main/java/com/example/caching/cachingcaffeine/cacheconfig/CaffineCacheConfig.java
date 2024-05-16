package com.example.caching.cachingcaffeine.cacheconfig;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CaffineCacheConfig {
	
//	@Bean
//	public Caffeine caffeine() {
//		return Caffeine.newBuilder()
//				        .expireAfterAccess(20, TimeUnit.SECONDS);
//	}
//	
//	@Bean
//	public CacheManager cacheManager(Caffeine caffeine) {
//	    CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
//	    caffeineCacheManager.setCaffeine(caffeine);
//	    return caffeineCacheManager;
//	}

}
