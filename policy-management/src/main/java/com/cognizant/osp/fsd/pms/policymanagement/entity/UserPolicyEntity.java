package com.cognizant.osp.fsd.pms.policymanagement.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name="User_Policy")
public class UserPolicyEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="userId")
	private UserEntity user;
	@ManyToOne
	@JoinColumn(name="policyId")
	private PolicyEntity policy;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userPolicyId;
	
	private Double amountPaid;
	private Date policyEndDate;
	private Boolean valid;
	
	
}
