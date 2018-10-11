package com.cognizant.osp.fsd.pms.policymanagement.dto;

import com.cognizant.osp.fsd.pms.policymanagement.entity.PolicyEntity;

import lombok.Data;

@Data
public class PolicyDTO {
	public PolicyDTO(PolicyEntity policyEntity) {
		this.policyId = policyEntity.getPolicyId();
		this.policyDetails = policyEntity.getPolicyDetails();
		this.policyName = policyEntity.getPolicyName();
	}

	private Integer policyId;
	private String policyName;
	private String policyDetails;

}
