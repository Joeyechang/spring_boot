package com.tts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JunitMockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitMockitoApplication.class, args);
	}
}
