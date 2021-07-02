package com.fis.ims.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
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

}
