package com.spandiar.spring.cachelearnings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheLearningsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheLearningsApplication.class, args);
	}

}
