package com.qa.infosysdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.qa.infosysdemo.controller.CarController;

@SpringBootApplication
public class InfosysDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfosysDemoApplication.class, args);
		
//		System.out.println(beanbag.containsBean(greeting()));
//		CarController controller = beanbag.getBean(CarController.class);
//		System.out.println(controller.sayHello());
	}
	
	//Bean - managed object
	//meaning the creating, maintenance, and destruction of the objecct is ALL done by Spring
	
	@Bean
	public static String greeting() {
		return "Hello World";
	}

}
