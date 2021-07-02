package com.fis.ims.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ims.entities.User;
import com.fis.ims.models.UserModel;
import com.fis.ims.services.UserService;

@RestController
@RequestMapping("/api/ims")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/get/all")
	public List<UserModel> getAllUsers() {
		List<User> userList = userService.getAllUsers();
		List<UserModel> userModels = new ArrayList<UserModel>();
		userList.stream().forEach(user -> {
			userModels.add(new UserModel(user));
		});
		return userModels;
	}
}
