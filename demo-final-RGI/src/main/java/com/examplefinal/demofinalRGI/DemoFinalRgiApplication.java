package com.examplefinal.demofinalRGI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class DemoFinalRgiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoFinalRgiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoFinalRgiApplication.class);
	}
}
