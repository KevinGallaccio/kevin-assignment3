package com.coderscampus.Assignment3;

// In this UserService class, I have 3 methods that will be used in the Runnable class :
// - the basic createUser method to have an array of String attached to a user  -- it is used in the DataReader class to create 
//    and attached values (username, password, name) to the existing users in the database.
//
// - a isValidLogin method that will check if the username and the password match with the database
//
// - I had to do an extra "getValidName" method to get the name of the known user in the database once the login is successful.
//
// - I also needed 2 other helper methods to make isValidLogin simpler (isUsernameMatch and isPasswordMatch.

public class UserService {

	public static User createUser(String[] stringInput) {
		User user = new User();
		user.setUsername(stringInput[0].trim());
		user.setPassword(stringInput[1].trim());
		user.setName(stringInput[2].trim());
		return user;
	}

	public static boolean isUsernameMatch(String storedUsername, String inputUsername) {
		return storedUsername.equalsIgnoreCase(inputUsername);
	}

	public static boolean isPasswordMatch(String storedPassword, String inputPassword) {
		return storedPassword.equals(inputPassword);
	}

	public static boolean isValidLogin(User[] knownUsers, String inputUsername, String inputPassword) {
		for (User user : knownUsers) {
			if (user != null && isUsernameMatch(user.getUsername(), inputUsername)
					&& isPasswordMatch(user.getPassword(), inputPassword)) {
				return true;
			}
		}
		return false;
	}

	public static String getValidName(User[] knownUsers, String inputUsername) {
		for (User user : knownUsers) {
			if (user != null && isUsernameMatch(user.getUsername(), inputUsername)) {
				return user.getName();
			}
		}
		return null;
	}

}
