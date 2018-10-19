package com.cognizant.osp.fsd.pms.policymanagement.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name="Policy")
public class PolicyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;
	private String policyName;
	private String policyDetails;


	@OneToMany(mappedBy="user")
	private List<UserPolicyEntity> userPolicies;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicyEntity policyEntity = (PolicyEntity) o;
        return Objects.equals(policyId, policyEntity.policyId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(policyId);
    }

}
