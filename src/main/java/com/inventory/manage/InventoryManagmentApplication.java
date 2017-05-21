package com.inventory.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class InventoryManagmentApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryManagmentApplication.class, args);
	}
	
	 private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
	        return builder.sources(InventoryManagmentApplication.class).bannerMode(org.springframework.boot.Banner.Mode.OFF);
	    }
}
