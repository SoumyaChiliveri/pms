package com.cognizant.osp.fsd.pms.policymanagement.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity(name="Policy")
public class PolicyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;
	private String policyName;
	private String policyDetails;

	@ManyToMany
	(mappedBy = "policies")
	//@JoinTable(name="USER_POLICY")
	private Set<UserEntity> users;
	
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
