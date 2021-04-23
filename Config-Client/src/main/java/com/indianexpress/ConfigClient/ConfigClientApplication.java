package com.indianexpress.ConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@SpringBootApplication
@RestController
public class ConfigClientApplication {

	@Value("${user.role}")
	private String role;

	@Value("${debug}")
	private String debug;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}


	@GetMapping(value = "/check-config/")
	public String check() {
		return String.format("Hello %s %s",role,debug);
	}
}
