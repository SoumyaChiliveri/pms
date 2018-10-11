package com.cognizant.osp.fsd.pms.policymanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.osp.fsd.pms.policymanagement.dto.PolicyDTO;
import com.cognizant.osp.fsd.pms.policymanagement.repository.PolicyRepository;

@Service
public class PolicyService {
	@Autowired
	private PolicyRepository policyRepository;

	public List<PolicyDTO> getAllPoliciesForUser(String username) {
		if("Admin".equalsIgnoreCase(username)) {
			return policyRepository.findAll().stream().map(policyEntity -> new PolicyDTO(policyEntity)).collect(Collectors.toList());
		}else {
			return policyRepository.findByUsers_Username(username).stream().map(policyEntity -> new PolicyDTO(policyEntity)).collect(Collectors.toList());
		}
		
		
	}

}
