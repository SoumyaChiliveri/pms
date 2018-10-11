package com.cognizant.osp.fsd.pms.policymanagement.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PolicyUserDTO {
	private UserDTO userDTO;
	private PolicyDTO policyDTO;
	private Double amountPaid;
	private Date policyEndDate;
	private Boolean valid;

}
