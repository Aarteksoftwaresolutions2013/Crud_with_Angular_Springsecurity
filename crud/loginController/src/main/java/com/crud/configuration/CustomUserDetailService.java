package com.crud.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.model.Users;
import com.crud.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user =  userService.findUserByEmail(email);
		if(user==null)
			throw new UsernameNotFoundException("Username not found");
		else
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
	                 true, true, true, true, getGrantedAuthorities(user));
	}
	
	  private List<GrantedAuthority> getGrantedAuthorities(Users user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	         
	        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
	        System.out.print("authorities :"+authorities+"role "+user.getRole());
	        return authorities;
	    }
}
