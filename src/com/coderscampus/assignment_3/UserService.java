package com.coderscampus.assignment_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {
	// Please review these below and verify they can belong here
	// Go back through the early videos to verify you are ok
	String username;
	String password;
	String name;
	User[] users = new User[4];
	int i;
	int numAttemptsLeft = 5;
	boolean loggedIn = false;

	User[] readFile() throws IOException {
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
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

	String userValidation() throws IOException {
		User[] users = readFile();
		Scanner scanner = new Scanner(System.in);
		while (loggedIn != true && numAttemptsLeft > 0) {
			System.out.println("Enter your email:");
			String inputtedUsername = scanner.nextLine();
			System.out.println("Enter your password:");
			String inputtedPassword = scanner.nextLine();
			for (User user2 : users) {
				for (User user : users) {
					if ((user.getUsername().equalsIgnoreCase(inputtedUsername)) && (user.getPassword().equals(inputtedPassword))) {
						loggedIn = true;
						System.out.println("Welcome: " + user.getName());
						break;
					}
				}
				if (loggedIn == true) {
					break;
				} else {
					if (numAttemptsLeft > 1 && (user2.getUsername() != inputtedUsername || (user2.getPassword() != inputtedPassword))) {
						System.out.println("Invalid login, please try again");
					} else if (numAttemptsLeft == 1) {
						System.out.println("Too many failed login attempts, you are now locked out.");
					}
					numAttemptsLeft--;
					// FOR MY TESTING PURPOSES ONLY
					// System.out.println("numAttemptsLeft: " + numAttemptsLeft);
					break;
				}	
			}
		}
		scanner.close();
		return null;
		
		// added a new comment to push to github
	}
}

