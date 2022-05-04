package com.example.Resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResttemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResttemplateApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	 
	var factory = new SimpleClientHttpRequestFactory();
	factory.setConnectTimeout(3000);
	factory.setReadTimeout(3000);
	
	return new RestTemplate(factory);
	}

}
