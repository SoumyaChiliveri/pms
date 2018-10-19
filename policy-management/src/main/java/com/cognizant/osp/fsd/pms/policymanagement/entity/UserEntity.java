package com.cognizant.osp.fsd.pms.policymanagement.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private String password;

	@OneToMany(mappedBy="policy")
	private List<UserPolicyEntity> userPolicies;
	

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        return userId != null && userId.equals(((UserEntity) o).userId);
    }
 
    @Override
    public int hashCode() {
        return userId;
    }
}
