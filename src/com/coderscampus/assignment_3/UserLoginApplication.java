package com.coderscampus.assignment_3;

import java.io.IOException;
// switching to feature branch to refactor this project
public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
		UserService userService = new UserService();
		userService.userValidation();
	}
}