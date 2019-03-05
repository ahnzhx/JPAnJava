package com.example.sonniespringdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@PropertySource("classpath:/application.properties")
public class SonnieSpringDevApplication {

	@GetMapping("/hello")
	public String hello(){
		return "hello springboot framework";
	}

	public static void main(String[] args) {
		//웹 어플리케이션 띄우지 않기
//		SpringApplication app = new SpringApplication(SonnieSpringDevApplication.class);
//		app.setWebApplicationType(WebApplicationType.NONE);
//		app.run(args);

		SpringApplication.run(SonnieSpringDevApplication.class);
	}

	@Bean
	public MessageSource messageSource(){
		var messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(3);
		return messageSource;
	}

}
