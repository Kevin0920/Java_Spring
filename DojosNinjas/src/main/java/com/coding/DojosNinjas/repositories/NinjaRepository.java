package com.coding.DojosNinjas.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.coding.DojosNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{


}