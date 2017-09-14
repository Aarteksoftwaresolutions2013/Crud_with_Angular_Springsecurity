package com.aartek.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aartek.model.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	/**
	 *  Find by email and password
	 *  @param String email
	 *  @param String password
	 *  
	 *  return Users
	 * */
	Users findByEmailAndPassword(String email, String password);

	Users findByEmail(String email);

}
