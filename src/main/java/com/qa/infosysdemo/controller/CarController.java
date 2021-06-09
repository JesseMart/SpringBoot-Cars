package com.qa.infosysdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.infosysdemo.domain.Car;


@RestController
//RestController is a child of Bean 
public class CarController {
	
	
	@GetMapping("/hello")
	public String sayHi() {
		return "Hello World";
	}
	
	private List<Car> vehicles = new ArrayList<>();
	
	//List - Create a new car - Add a car to a list
	//Read a car from a list
	//Update a car
	//Delete a car
	
	//CREATE
	@PostMapping("/create")
	public String createVehicle(@RequestBody Car car) {
		this.vehicles.add(car);
		return "Succesfully Added Car!";
	}
	//READ
	@GetMapping("/getAll")
	public List<Car> getAllVehicles() {
		return this.vehicles;
	}
	//DELETE
	@DeleteMapping("/remove/{index}")
	public Car removeVehicle(@PathVariable int index) {
		return this.vehicles.remove(index);
	}
	//REad ONe
	@GetMapping("getOne/{index}")
	public Car getOneVehicle(@PathVariable int index) {
		return this.vehicles.get(index);
	}
	
}
