package com.fis.ims.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ims.entities.Role;
import com.fis.ims.entities.User;
import com.fis.ims.services.RoleService;
import com.fis.ims.services.UserService;

@RestController
@RequestMapping("/api/ims")
public class RoleController {

	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	@GetMapping("/roles")
	public List<Role> getRole() {
		List<Role> roleList = roleService.getRoles();
		return roleList;
	}

	@GetMapping("/role/{roleId}")
	public Role getByRoleId(@PathVariable String roleId) {
		return roleService.findRoleById(roleId);
	}

	@PostMapping("/create/role")
	public ResponseEntity<Role> createRole(@Valid @RequestBody Role role) {
		if (role.getRoleId() != null) {
			User user = userService.getUserbyId(role.getRoleId());
			role.setUser(user);
		}
		Role saveRole = roleService.create(role);
		return new ResponseEntity<Role>(saveRole, HttpStatus.CREATED);
	}

}
