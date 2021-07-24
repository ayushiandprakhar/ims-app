package com.fis.ims.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ims.entities.User;
import com.fis.ims.models.UserRequestModel;
import com.fis.ims.models.UserResponseModel;
import com.fis.ims.services.AssetService;
import com.fis.ims.services.UserService;

@RestController
@RequestMapping("/api/ims")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AssetService assetService;

	@GetMapping("/get/all")
	public List<UserResponseModel> getAllUsers() {
		List<User> userList = userService.getAllUsers();
		List<UserResponseModel> userModels = new ArrayList<UserResponseModel>();
		userList.stream().forEach(user -> {
			userModels.add(new UserResponseModel(user));
		});
		return userModels;
	}

	@PostMapping("/createUser")
	public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel userRequestModel) {
		User user = userService.createUser(userRequestModel);
		return new ResponseEntity<UserResponseModel>(new UserResponseModel(user), HttpStatus.CREATED);
	}

	@PutMapping("/request/asset/{employeeId}/{assetId}")
	public ResponseEntity<User> requestAsset(@PathVariable String employeeId, @PathVariable String assetId) {
		if (assetService.allocateAsset(assetId, employeeId)) {
			return new ResponseEntity<User>(userService.getUserbyId(employeeId), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}

}
