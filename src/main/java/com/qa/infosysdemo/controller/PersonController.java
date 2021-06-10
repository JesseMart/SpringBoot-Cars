package com.qa.infosysdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.qa.infosysdemo.service.PersonService;



@RestController
public class PersonController {
	
//	private List<Person> people = new ArrayList<>();
	
	private PersonService service;
	
	
	
//	@GetMapping("/test")
//	public String test() {
//		return "Hello World";
//	}
	
	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}
	
	
///CREATE ------------------------------------------------
	
//	@PostMapping("/createPerson")
//	public boolean addPerson(@RequestBody Person person) {
//		return this.people.add(person);
//	}
	
	// +== USING RESPONSE ENTITY ==+
//	@PostMapping("/createPerson")
//	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
//		this.people.add(person);
//		System.out.println("New Person Created");
//		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
//	}
	
	//+== SERVICE ==+
	@PostMapping("/createPerson")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(this.service.addPerson(person),HttpStatus.CREATED);
	}
	
	
	
//READ-------------------------------------------------------------------
	
	// +== USING RESPONSE ENTITY ==+
//	@GetMapping("/getAllPersons")
//	public ResponseEntity<List<Person>> getAllPersons(){
//		return ResponseEntity.ok(this.people);
//	}
	
	//+== SERVICE ==+
	@GetMapping("/getAllPersons")
	public ResponseEntity<List<Person>> getAllPersons(){
		return ResponseEntity.ok(this.service.getAllPersons());
	}
	
	
//	public List<Person> getAll() {
//		return this.people;
//	}
	
	
//UPDATE & PATCH----------------------------------------------------
	
	// +== USING RESPONSE ENTITY ==+
//	@PutMapping("/update")
//	public ResponseEntity<Person> updatePerson(@PathParam("name")String name, @PathVariable int index){
//		Person updatedPerson = this.people.get(index);
//		updatedPerson.setName(name);
//		return new ResponseEntity<Person>(updatedPerson, HttpStatus.ACCEPTED);
//	}
	
	//+== SERVICE ==+
	@PutMapping("/update")
	public ResponseEntity<Person> updatePerson(@PathVariable int index, @RequestBody Person newPerson){
		this.service.updatePerson(index, newPerson);
		return new ResponseEntity<Person>(newPerson, HttpStatus.ACCEPTED);
	}
	
//	public Person updatePerson(@PathParam("id")int id,@RequestBody Person person) {
//		this.people.remove(id);
//		this.people.add(id, person);
//		return this.people.get(id);
//	}
//	
//DELETE----------------------------------------------------------------------

	//+== SERVICE ==+
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Person> removePerson(@PathVariable int index) {
		return this.service.removePerson(index) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
//	@DeleteMapping("/delete/{id}")
//	public Person removePerson(@PathVariable int id) {
//		return this.people.remove(id);
//	}
	
}
