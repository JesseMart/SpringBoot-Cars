package com.qa.infosysdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//RestController is a hild of Bean 
public class CarController {
	
	
	@GetMapping("/hello")
	public String sayHi() {
		return "Hello World";
	}
}
