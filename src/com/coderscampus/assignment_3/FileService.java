package com.coderscampus.assignment_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	private final String FILENAME = "data.txt";

	public User[] readFile() throws IOException {
		BufferedReader fileReader = null;
		User[] users = new User[4];

		try {
			int i = 0;
			fileReader = new BufferedReader(new FileReader(FILENAME));
			String line;
			while ((line = fileReader.readLine()) != null) {
				String[] userInfo = line.split(",");

				String username = userInfo[0];
				String password = userInfo[1];
				String name = userInfo[2];

				User user = new User(username, password, name);
				users[i] = user;
				i++;
			}
		} finally {
			fileReader.close();
		}
		return users;
	}
}
