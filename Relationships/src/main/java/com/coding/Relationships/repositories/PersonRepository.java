package com.coding.Relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.Relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
}
