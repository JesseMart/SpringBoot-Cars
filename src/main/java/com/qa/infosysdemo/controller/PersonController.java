package com.qa.infosysdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.qa.infosysdemo.domain.Person;



@RestController
public class PersonController {
	
	private List<Person> people = new ArrayList<>();
	
	
	
	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}
	///CREATE 
	@PostMapping("/createPerson")
	public boolean addPerson(@RequestBody Person person) {
		return this.people.add(person);
	}
	//READ
	@GetMapping("/getAllPersons")
	public List<Person> getAll() {
		return this.people;
	}
	//UPDATE
	@PutMapping("/update")
	public Person updatePerson(@PathParam("id")int id,@RequestBody Person person) {
		this.people.remove(id);
		this.people.add(id, person);
		return this.people.get(id);
	}
	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public Person removePerson(@PathVariable int id) {
		return this.people.remove(id);
	}
	
}
