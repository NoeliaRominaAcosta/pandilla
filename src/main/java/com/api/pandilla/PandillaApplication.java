package com.api.pandilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.api.pandilla", "mappers"})
public class PandillaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandillaApplication.class, args);
	}

}
