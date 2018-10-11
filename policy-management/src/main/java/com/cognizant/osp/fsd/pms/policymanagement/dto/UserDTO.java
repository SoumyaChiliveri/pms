package com.cognizant.osp.fsd.pms.policymanagement.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.cognizant.osp.fsd.pms.policymanagement.entity.PolicyEntity;
import com.cognizant.osp.fsd.pms.policymanagement.entity.UserEntity;

import lombok.Data;

@Data
public class UserDTO {
	private Set<PolicyDTO> policies;
	private Integer userId;

	public UserDTO(UserEntity userEntityValue) {
		this.address = userEntityValue.getAddress();
		this.email = userEntityValue.getEmail();
		this.firstName = userEntityValue.getFirstName();
		this.lastName = userEntityValue.getLastName();
		this.phone = userEntityValue.getPhone();
		this.username = userEntityValue.getUsername();
		this.policies = getPolicyDTOs(userEntityValue.getPolicies());
		this.userId = userEntityValue.getUserId();
	}

	private String username;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	
	private Set<PolicyDTO> getPolicyDTOs(Set<PolicyEntity> policyEntitySet){
		Set<PolicyDTO> policyDTOSet = policyEntitySet.stream().map(policyEntity -> new PolicyDTO(policyEntity)).collect(Collectors.toSet());
		return policyDTOSet;
	}

	
	
}
