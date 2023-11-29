package com.coderscampus.Assignment3;

import java.io.IOException;
import java.util.Scanner;

public class RunnableUserService {

	public static String reset = "\u001B[0m";
	public static String cyan = "\u001B[36m";
	public static String italicYellow = "\u001B[3;33m";
	public static String italicRed = "\u001B[3;31m";
	
	
// This main class is very straight forward and inspired from the previous assignment.
// with all the methods from previous classes, I can now Scan for an email and password input  from user
// and compare them with the "knownUsers" variable from DataReader class with the 'isValidLogin' method from UserService class.

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try {
			User[] knownUsers = DataReader.readUsersFromFile();

			int loginAttempts = 0;
			int maxLoginAttempts = 5;

			while (loginAttempts < maxLoginAttempts) {

				System.out.println(italicYellow + "Enter your email: " + reset);
				String inputUsername = scanner.nextLine();

				System.out.println(italicYellow + "Enter your password" + reset);
				String inputPassword = scanner.nextLine();

				if (UserService.isValidLogin(knownUsers, inputUsername, inputPassword)) {
					System.out.println(cyan + "Welcome: "
							+ UserService.getValidName(knownUsers, inputUsername) 
							+ reset);
					break;

				} else if (loginAttempts < 4) {
					System.out.println(italicRed + "Invalid login, please try again"
							+ (loginAttempts == 3 ? ", you have one last attempt before being locked out" : "")
							+ reset);

				}
				loginAttempts++;
			}

			if (loginAttempts == maxLoginAttempts) {
				System.out.println(italicRed + "Too many failed login attempts, you are now locked out." + reset);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
