package com.cognizant.osp.fsd.pms.policymanagement.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.cognizant.osp.fsd.pms.policymanagement.entity.UserEntity;
import com.cognizant.osp.fsd.pms.policymanagement.entity.UserPolicyEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	private List<PolicyUserDTO> userPolicies;
	private Integer userId;

	public UserDTO(UserEntity userEntityValue) {
		this.address = userEntityValue.getAddress();
		this.email = userEntityValue.getEmail();
		this.firstName = userEntityValue.getFirstName();
		this.lastName = userEntityValue.getLastName();
		this.phone = userEntityValue.getPhone();
		this.username = userEntityValue.getUsername();
		this.userPolicies = getPolicyDTOs(userEntityValue.getUserPolicies());
		this.userId = userEntityValue.getUserId();
		this.password = userEntityValue.getPassword();
	}

	private String username;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	private String password;
	
	private List<PolicyUserDTO> getPolicyDTOs(List<UserPolicyEntity> policyUserEntityList){
		List<PolicyUserDTO> policyUserDTOList = policyUserEntityList.stream().map(policyEntity -> new PolicyUserDTO(policyEntity,policyEntity.getPolicy())).collect(Collectors.toList());
		return policyUserDTOList;
	}

	
	
}
