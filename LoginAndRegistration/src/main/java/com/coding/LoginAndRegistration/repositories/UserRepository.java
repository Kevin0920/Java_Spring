package com.coding.LoginAndRegistration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.LoginAndRegistration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findOneByUsername(String userName);

}
