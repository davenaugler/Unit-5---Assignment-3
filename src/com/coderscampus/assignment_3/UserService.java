package com.coderscampus.assignment_3;

import java.io.IOException;
import java.util.Scanner;

public class UserService {

	private FileService fileService = new FileService();
	private User[] users = new User[4];

	public UserService () {
		loadUsers();
	}

	private void loadUsers() {
		try {
			users = fileService.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		for (User user : users) {
			if ((user.getUsername().equalsIgnoreCase(username)) && (user.getPassword().equals(password))) {
				return user;
			}
		}
		return null;
	}

	public void initiateLogin() throws IOException {
		int numAttemptsLeft = 5;
		Scanner scanner = new Scanner(System.in);

		User loggedInUser = null;
		while (numAttemptsLeft > 0) {
			System.out.println("Enter your email:");
			String inputtedUsername = scanner.nextLine();
			System.out.println("Enter your password:");
			String inputtedPassword = scanner.nextLine();

			loggedInUser = getUserByUsernameAndPassword(inputtedUsername, inputtedPassword);

			if (loggedInUser != null) {
				System.out.println("Welcome: " + loggedInUser.getName());
				break;
			} else if (numAttemptsLeft > 1) {
				System.out.println("Invalid login, please try again");
			} else if (numAttemptsLeft == 1) {
				System.out.println("To many login attempts, you are now locked out.");
			}

			numAttemptsLeft--;
		}

		scanner.close();

	}

}
