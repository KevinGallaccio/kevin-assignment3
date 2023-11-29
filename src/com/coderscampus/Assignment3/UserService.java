package com.coderscampus.Assignment3;

public class UserService {

	// createUser method that takes an array of 3 Strings (username, password, name) as input:
	
	public User createUser(String[] stringInput) {
		User user = new User();
		user.setUsername(stringInput[0]);
		user.setPassword(stringInput[1]);
		user.setName(stringInput[2]);
		return user;
	}

}
