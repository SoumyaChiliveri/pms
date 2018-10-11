package com.cognizant.osp.fsd.pms.policymanagement.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name = "User")
@Data

public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer userId;

	private String username;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	@ManyToMany
	@JoinTable(name = "User_Policy"
			,joinColumns = {@JoinColumn (name= "userId")}
			, inverseJoinColumns = { @JoinColumn(name = "policyId") })
	private Set<PolicyEntity> policies;
	
	public void addPolicy(PolicyEntity policy) {
        policies.add(policy);
        policy.getUsers().add(this);
    }
 
    public void removePolicy(PolicyEntity policy) {
        policies.remove(policy);
        policy.getUsers().remove(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        return userId != null && userId.equals(((UserEntity) o).userId);
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
}
