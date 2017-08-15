package com.coding.ProductsCate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.ProductsCate.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	

}
