package com.qa.infosysdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.infosysdemo.domain.Person;

@Repository
public interface PeopleRepo extends JpaRepository<Person, Long> {

	
	//Person - is out entity
	//Long - ID data type
}
