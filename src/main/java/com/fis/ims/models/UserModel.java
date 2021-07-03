package com.fis.ims.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fis.ims.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	@JsonIgnore
	private long id;

	@JsonProperty("User_Name")
	private String userName;

	@JsonProperty("Manager_Name")
	private String managerName;

	@JsonProperty("Employeee_Id")
	private String employeeId;

	private String email;

	@JsonIgnore
	private String password;

	public UserModel(User user) {
		this.userName = user.getUserName();
		this.managerName = user.getManagerName();
		this.employeeId = user.getEmployeeId();
		this.email = user.getEmail();
	}
}
