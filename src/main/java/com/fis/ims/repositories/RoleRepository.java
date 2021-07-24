package com.fis.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ims.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleId(String roleId); 
}
