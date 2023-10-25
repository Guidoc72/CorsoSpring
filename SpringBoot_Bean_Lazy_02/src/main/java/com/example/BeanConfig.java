package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanConfig {

	@Bean
	public UsataSpesso getUsataSpesso() {
		return new UsataSpesso();
	}
	
	@Bean
	@Lazy
	public UsataRaramente getUsataRaramente() {
		return new UsataRaramente();
	}
}


