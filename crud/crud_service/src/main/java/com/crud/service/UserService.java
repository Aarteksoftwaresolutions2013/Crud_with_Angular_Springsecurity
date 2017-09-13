package com.crud.service;

import java.util.List;

import com.crud.model.Users;

public interface UserService {
	
	/**
	 * Find By Email and Password
	 * @param Users
	 * 
	 * return Users
	 * */
	public Users findByEmailAndPassword(Users user);
	
	/**
	 * Get All User List
	 * 
	 * return List<Users>
	 * 
	 */
	public List<Users> getAllUsers();
	
	
	public Users findUserByEmail(String userName);
}
