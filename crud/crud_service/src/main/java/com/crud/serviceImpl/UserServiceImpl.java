package com.crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Users;
import com.crud.repository.UserRepository;
import com.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Find by email and Password
	 * @param Users
	 * 
	 * return Users 
	 * */
	public Users findByEmailAndPassword(Users user){
		return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}

	/**
	 * Get all users
	 * 
	 * return List<Users>
	 * */
	public List<Users> getAllUsers() {
		
	  List<Users> userList = userRepository.findAll();
		return userList;
	}

	public Users findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
