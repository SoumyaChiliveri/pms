package com.cognizant.osp.fsd.pms.policymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.osp.fsd.pms.policymanagement.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public Optional<UserEntity> findByUsername(String username);
	
}
