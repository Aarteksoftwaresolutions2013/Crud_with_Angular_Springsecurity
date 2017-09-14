package com.aartek.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@RequestMapping(value="/rest/admin")
	public ResponseEntity<Map<String,String>> sampleData(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "You access the admin api with admin credentials.");
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
	}
}


