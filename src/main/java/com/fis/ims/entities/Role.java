package com.fis.ims.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "role_id")
	private String roleId;
	
	@OneToOne
	@JoinTable(name = "user_role_table", 
    joinColumns = {@JoinColumn(name="role_id")},
    inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private User user;
	
}
