package com.crud.model;

public enum Role {
	
	ADMIN("ADMIN"),
	USER("USER");
	
	private String roleName;
	
	Role(String roleName){
		this.roleName = roleName;
	}
	
	public String getRoleName(){
		return this.roleName;
	}
}
