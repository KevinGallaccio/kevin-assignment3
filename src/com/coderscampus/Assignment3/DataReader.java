package com.coderscampus.Assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// I chose to have a separate DataReader class for more visibility on how the data was extracted from the .txt file
// I am using a BufferedReader as explained in lessons 10 and 11 and I'm coupling it with the createUser method from UserService class.
//
// once 'User[] knownUsers = DataReader.readUsersFromFile();' is ran in the RunnableUserService class,
// 4 users are created as per the data.txt file and it populated the 'knownUsers' variable.


public class DataReader {

	public static User[] readUsersFromFile() throws IOException {
		User[] knownUsers = new User[4];
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line;

			int index = 0;

			while ((line = fileReader.readLine()) != null) {
				String[] userInfo = line.split(",");
				User user = UserService.createUser(userInfo);
				knownUsers[index++] = user;
			}

		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return knownUsers;
	}
}
