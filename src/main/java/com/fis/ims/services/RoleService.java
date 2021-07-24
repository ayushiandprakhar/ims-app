package com.fis.ims.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ims.entities.Role;
import com.fis.ims.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getRoles() {
		return roleRepository.findAll(); 
	}
	
	public Role findRoleById(String roleId) {
		return roleRepository.findByRoleId(roleId);
	}

	public Role create(@Valid Role role) {
		return roleRepository.save(role);
	}
}
