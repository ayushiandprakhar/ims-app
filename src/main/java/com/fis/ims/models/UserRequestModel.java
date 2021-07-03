package com.fis.ims.models;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestModel {

	@JsonProperty("User_Name")
	@NotBlank(message = "User Name is required")
	private String userName;

	@JsonProperty("Manager_Name")
	@NotBlank(message = "Manager Name is required")
	private String managerName;

	@JsonProperty("Employeee_Id")
	@NotBlank(message = "Employee Id is required")
	private String employeeId;

	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Password is required")
	private String password;
	
	
}
