package com.zosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zosh.repository")
public class TreadingPlateformApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreadingPlateformApplication.class, args);
	}

}
