package com.fis.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ims.entities.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long>{

}
