package com.coderscampus.Assignment3;

import java.util.Scanner;

public class RunnableUserService {

	// Setting up colors:

	public static String reset = "\u001B[0m";
	public static String cyan = "\u001B[36m";
	public static String italicYellow = "\u001B[3;33m";

	public static void main(String[] args) {

		// Creating new users with createUser method from UserService class:

		UserService userService = new UserService();

		// creating user1 from set variables with an Array of 3 Strings:

		String[] user1Input = new String[3];
		user1Input[0] = "tp02ga";
		user1Input[1] = "pass123";
		user1Input[2] = "Trevor Page";
		User user1 = userService.createUser(user1Input);

		// Testing User 1:

		System.out.println(cyan + "USER 1 CREATED:" + reset);
		System.out.println(user1);
		System.out.println();
		System.out.println(cyan + "TEST:");
		System.out.println("Username: " + user1.getUsername());
		System.out.println("Password: " + user1.getPassword());
		System.out.println("Name: " + user1.getName() + reset);
		System.out.println();
		
		
		
		
		
		
		
		
		// Extra work, I wanted to manually input the info on the console
		// I am creating user2 from Scanner
		// it works because createUser needs an array of 3 Strings and user2Input has 3
		// Strings inside of it

		Scanner scanner = new Scanner(System.in);

		String[] user2Input = new String[3];
		System.out.println(italicYellow + "USER 2, Enter username: " + reset);
		user2Input[0] = scanner.next();
		System.out.println(italicYellow + "Enter Password: " + reset);
		user2Input[1] = scanner.next();
		System.out.println(italicYellow + "Enter Name: " + reset);
		scanner.nextLine();

		// for the Name I used scanner.nextLine() instead of scanner.next() to grab all
		// the info and not only the first word.
		// I had to add a scanner.nextLine(); before to consume the newline character,
		// otherwise I was not given the chance to enter the Name
		
		user2Input[2] = scanner.nextLine();
		User user2 = userService.createUser(user2Input);

		System.out.println();

		// Testing User 2 (from User Input)

		System.out.println(cyan + "USER 2 CREATED:" + reset);
		System.out.println(user2);
		System.out.println();
		System.out.println(cyan + "TEST:");
		System.out.println("Username: " + user2.getUsername());
		System.out.println("Password: " + user2.getPassword());
		System.out.println("Name: " + user2.getName() + reset);

		scanner.close();

	}

}
