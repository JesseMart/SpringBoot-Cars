package com.qa.infosysdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	///CREATE ------------------------------------------------
//	@PostMapping("/createPerson")
//	public boolean addPerson(@RequestBody Person person) {
//		return this.people.add(person);
//	}
	
	@PostMapping("/createPerson")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		this.people.add(person);
		System.out.println("New Person Created");
		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}
	
	//READ-------------------------------------------------------
	@GetMapping("/getAllPersons")
	public ResponseEntity<List<Person>> getAllPersons(){
		return ResponseEntity.ok(this.people);
	}
	
//	public List<Person> getAll() {
//		return this.people;
//	}
	
	
	//UPDATE & PATCH----------------------------------------------------
	@PutMapping("/update")
	public ResponseEntity<Person> updatePerson(@PathParam("name")String name, @PathVariable int index){
		Person updatedPerson = this.people.get(index);
		updatedPerson.setName(name);
		return new ResponseEntity<Person>(updatedPerson, HttpStatus.ACCEPTED);
	}
//	public Person updatePerson(@PathParam("id")int id,@RequestBody Person person) {
//		this.people.remove(id);
//		this.people.add(id, person);
//		return this.people.get(id);
//	}
//	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public Person removePerson(@PathVariable int id) {
		return this.people.remove(id);
	}
	
}
