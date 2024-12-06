package com.preinterview.assignment;

import com.preinterview.assignment.service.OpenmeteoforecastService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PreinterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreinterviewApplication.class, args);
	}
	@Bean
	public RestTemplate getREstTemplate(){
		return new RestTemplate();
	}
}
