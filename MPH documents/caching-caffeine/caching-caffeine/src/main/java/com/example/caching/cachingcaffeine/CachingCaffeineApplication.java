package com.example.caching.cachingcaffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class CachingCaffeineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingCaffeineApplication.class, args);
	}

}
