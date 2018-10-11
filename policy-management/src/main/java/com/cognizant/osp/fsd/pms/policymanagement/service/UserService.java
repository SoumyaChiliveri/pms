package com.cognizant.osp.fsd.pms.policymanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cognizant.osp.fsd.pms.policymanagement.dto.UserDTO;
import com.cognizant.osp.fsd.pms.policymanagement.entity.UserEntity;
import com.cognizant.osp.fsd.pms.policymanagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean checkIfValidUser(String userid,String password) {
		UserEntity userEntity =new UserEntity();
		userEntity.setUsername(userid);
		
		Optional<UserEntity> optionalUserEntity = userRepository.findOne(Example.of(userEntity));
		return optionalUserEntity.isPresent();
		
	}
	
	public UserDTO registerUser(UserDTO userDTO) {
		UserEntity userEntity =new UserEntity();
		userEntity.setAddress(userDTO.getAddress());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setPhone(userDTO.getPhone());
		userEntity.setUsername(userDTO.getUsername());
		userRepository.saveAndFlush(userEntity);
		return userDTO;
	}

	public UserDTO getUserDetailsByUserName(String username) {
		
		Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(username);
		UserEntity userEntityValue = optionalUserEntity.get();
		UserDTO userDTO = new UserDTO(userEntityValue);
		return userDTO;
	}
	
	
}
