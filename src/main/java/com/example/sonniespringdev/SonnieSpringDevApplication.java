package com.example.sonniespringdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class SonnieSpringDevApplication {

	@GetMapping("/hello")
	public String hello(){
		return "hello springboot framework";
	}

	public static void main(String[]  args) {
		//웹 어플리케이션 띄우지 않기
//		SpringApplication app  = new SpringApplication(SonnieSpringDevApplication.class);
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
