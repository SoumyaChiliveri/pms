package com.cognizant.osp.fsd.pms.policymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.osp.fsd.pms.policymanagement.entity.PolicyEntity;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyEntity, Integer>{

	List<PolicyEntity> findByPolicyDetails(String username);
	
	
}
