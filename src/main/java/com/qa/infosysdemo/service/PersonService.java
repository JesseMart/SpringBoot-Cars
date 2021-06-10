package com.qa.infosysdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.infosysdemo.domain.Person;

@Service
public class PersonService {

		private List<Person> people ; // <-- Dependency
		
		//Constructor
		public PersonService (List<Person> people) {
			this.people = people;
		}
		
		//CREATE
		
		public Person addPerson(Person person) {
			this.people.add(person);
			System.out.println("New Person Added!");
			Person added = this.people.get(this.people.size() -1);
			
			return added;
		}
		
		//READ
		
		public List<Person> getAllPersons() {
			return this.people;
		}
		
		//READ ONE
		
		public Person getOnePerson(int index) {
			return this.people.get(index);
		}
		
		//DELETE
		
		public boolean removePerson(int index) {
			this.people.remove(index);
			return true;
		}
		
		//PUT - update whole person
		
		public Person updatePerson(int index, Person newPerson) {
			this.people.set(index, newPerson);
			return newPerson;
		}
}
