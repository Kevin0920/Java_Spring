package com.coding.Relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.Relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	License findOneByPersonId(Long person_id);
}
