package com.fis.ims.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fis.ims.models.UserRequestModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "manager_name")
	private String managerName;

	@Column(name = "employee_id")
	private String employeeId;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Asset> assetIssued;
	
	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Role role;

	public User(UserRequestModel userRequestModel) {
		this.userName = userRequestModel.getUserName();
		this.managerName = userRequestModel.getManagerName();
		this.employeeId = userRequestModel.getEmployeeId();
		this.email = userRequestModel.getEmail();
		this.password = userRequestModel.getPassword();
	}

}
