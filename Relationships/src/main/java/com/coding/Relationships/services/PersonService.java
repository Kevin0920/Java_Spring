package com.coding.Relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.Relationships.models.Person;
import com.coding.Relationships.repositories.PersonRepository;


@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	

	public void addPerson(Person person) {
		personRepository.save(person);
		
	}
	
	public List<Person> findAll(){
		return (List<Person>) personRepository.findAll();
	}

	public Person findPerson(Long id) {
		return personRepository.findOne(id);
	}

}
