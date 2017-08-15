package com.coding.ProductsCate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.ProductsCate.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
