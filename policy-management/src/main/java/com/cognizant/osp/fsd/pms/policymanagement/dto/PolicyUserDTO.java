package com.cognizant.osp.fsd.pms.policymanagement.dto;

import java.util.Date;

import com.cognizant.osp.fsd.pms.policymanagement.entity.PolicyEntity;
import com.cognizant.osp.fsd.pms.policymanagement.entity.UserPolicyEntity;

import lombok.Data;

@Data
public class PolicyUserDTO {
	public PolicyUserDTO(UserPolicyEntity policyEntity, PolicyEntity policy) {
		this.amountPaid = policyEntity.getAmountPaid();
		this.policyEndDate = policyEntity.getPolicyEndDate();
		this.valid = policyEntity.getValid();
		this.policyDTO = new PolicyDTO(policy);
	}
	//private UserDTO userDTO;
	private PolicyDTO policyDTO;
	private Double amountPaid;
	private Date policyEndDate;
	private Boolean valid;
	
}
