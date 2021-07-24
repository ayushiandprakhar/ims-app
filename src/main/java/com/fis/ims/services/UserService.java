package com.fis.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ims.entities.User;
import com.fis.ims.models.UserRequestModel;
import com.fis.ims.repositories.AssetRepository;
import com.fis.ims.repositories.UserRespository;

@Service
public class UserService {

	@Autowired
	UserRespository userRespository;
	
	@Autowired
	AssetRepository assetRepository;

	public List<User> getAllUsers() {
		return userRespository.findAll();
	}

	public User createUser(UserRequestModel userRequestModel) {
		User user = new User(userRequestModel);
		user = userRespository.save(user);
		return user;
	}

	public User getUserbyId(String allocatedTo) {
		User user = userRespository.findByEmployeeId(allocatedTo);
		return user;
	}

}
