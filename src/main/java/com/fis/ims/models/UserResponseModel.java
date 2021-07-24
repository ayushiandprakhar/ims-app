package com.fis.ims.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fis.ims.entities.Asset;
import com.fis.ims.entities.Role;
import com.fis.ims.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseModel {

	@JsonIgnore
	private long id;

	@JsonProperty("User_Name")
	private String userName;

	@JsonProperty("Manager_Name")
	private String managerName;

	@JsonProperty("Employeee_Id")
	private String employeeId;

	private String email;
	
	@JsonProperty("Allocated devices")
	private List<Asset> assetList;

	@JsonIgnore
	private String password;
	
	@JsonProperty("Role")
	private Role role;

	public UserResponseModel(User user) {
		this.userName = user.getUserName();
		this.managerName = user.getManagerName();
		this.employeeId = user.getEmployeeId();
		this.email = user.getEmail();
		this.assetList = user.getAssetIssued();
		this.role = user.getRole();
	}
}
