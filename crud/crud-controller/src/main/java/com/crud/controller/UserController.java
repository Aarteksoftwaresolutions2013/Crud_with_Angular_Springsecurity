package com.crud.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Users;
import com.crud.service.UserService;


/**
 * This class content the method of user related task.
 * 
 * @author aartek
 * @version 1.0
 * @since 13-Sep-2017
 * */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     *  To check the user is authenticated or not.
     *  @param user This object hold the user object.
     *  @return {@link ResponseEntity}
     * */
	@RequestMapping(value = "/rest/user", method = RequestMethod.POST)
	public ResponseEntity login(@RequestBody Users user){
		try{
			Users validUser = userService.findByEmailAndPassword(user);
			if(validUser!=null)
				return new ResponseEntity<Users>(validUser,HttpStatus.OK);
			else
			   return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			Map<String,String> map = new LinkedHashMap<String, String>();
			map.put("message", "An error occured");
			map.put("error", e.getMessage());
			return new ResponseEntity<Map<String, String>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Return list of the user.
	 * @author aartek
	 * @see {@link ResponseEntity}
	 * @return {@link ResponseEntity}
	 * */
	@RequestMapping(value = "/rest/user", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getAllUsers(){
			 List<Users> userList = userService.getAllUsers();
			if(!userList.isEmpty())
				return new ResponseEntity<List<Users>>(userList,HttpStatus.OK);
			else
			   return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
	}

}