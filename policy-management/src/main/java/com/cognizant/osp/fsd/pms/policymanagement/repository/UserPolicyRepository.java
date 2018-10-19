package com.cognizant.osp.fsd.pms.policymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.osp.fsd.pms.policymanagement.entity.UserEntity;
import com.cognizant.osp.fsd.pms.policymanagement.entity.UserPolicyEntity;

@Repository
public interface UserPolicyRepository extends JpaRepository<UserPolicyEntity, Integer>{
	
	public List<UserPolicyEntity> findAllByUser(UserEntity userId);
}
