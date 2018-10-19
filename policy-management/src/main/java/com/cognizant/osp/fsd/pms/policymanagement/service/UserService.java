package com.cognizant.osp.fsd.pms.policymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.osp.fsd.pms.policymanagement.dto.UserDTO;
import com.cognizant.osp.fsd.pms.policymanagement.entity.UserEntity;
import com.cognizant.osp.fsd.pms.policymanagement.repository.UserPolicyRepository;
import com.cognizant.osp.fsd.pms.policymanagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserPolicyRepository userPolicyRepository;
	
	public UserDTO loginUSer(String userid,String password) {
		UserEntity userEntity =new UserEntity();
		userEntity.setUsername(userid);
		userEntity.setPassword(password);
		
		Optional<UserEntity> optionalUserEntity = userRepository.findByUsernameAndPassword(userid, password);
		userPolicyRepository.findAllByUser(optionalUserEntity.get());
		return new UserDTO(optionalUserEntity.get());
		
	}
	
	public UserDTO registerUser(UserDTO userDTO) {
		UserEntity userEntity =new UserEntity();
		userEntity.setAddress(userDTO.getAddress());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setPhone(userDTO.getPhone());
		userEntity.setUsername(userDTO.getUsername());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setPhone(userDTO.getPhone());
		userRepository.saveAndFlush(userEntity);
		return userDTO;
	}

	public UserDTO getUserDetailsByUserId(Integer userId) {
		
		Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
		UserEntity userEntityValue = optionalUserEntity.get();
		UserDTO userDTO = new UserDTO(userEntityValue);
		return userDTO;
	}

	public List<UserDTO> getUsers() {
		return userRepository.findAll().stream().map(mapper -> new UserDTO(mapper)).collect(Collectors.toList());
		
		
	}
	
	
}
