package com.vms.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class VehicleManagementSystemApplication extends SpringBootServletInitializer implements WebMvcConfigurer
  {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(VehicleManagementSystemApplication.class);
    }
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleManagementSystemApplication.class, args);
	}
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 if (!registry.hasMappingForPattern("/assets/**")) {
		     registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets/");
		  }
	    }
	
	

}
