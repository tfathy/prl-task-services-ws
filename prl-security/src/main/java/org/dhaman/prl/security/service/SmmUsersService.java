package org.dhaman.prl.security.service;

import org.dhaman.prl.security.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SmmUsersService  extends UserDetailsService{
	
	public UserDto createUser(UserDto userDetails);	
	public UserDto getUserDetailsByEmail(String email);
	public UserDto getUserByUserId(String userId);
	

}
