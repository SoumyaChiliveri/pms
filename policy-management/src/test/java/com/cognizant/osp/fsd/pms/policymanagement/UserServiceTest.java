package com.cognizant.osp.fsd.pms.policymanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.cognizant.osp.fsd.pms.policymanagement.dto.UserDTO;
import com.cognizant.osp.fsd.pms.policymanagement.repository.UserRepository;
import com.cognizant.osp.fsd.pms.policymanagement.service.UserService;

public class UserServiceTest {

	@Mock
	UserRepository userRepository;

	@Test
	public void testLoginUSer() {
		UserService userService = Mockito.mock(UserService.class);
		UserDTO e = new UserDTO();
		e.setUsername("Admin");
		when(userService.loginUSer(Mockito.anyString(),Mockito.anyString())).thenReturn(e);
		UserDTO user = userService.loginUSer("Admin", "password");
		assertEquals(user.getUsername(), "Admin");
	}

	@Test
	public void testRegisterUser() {
		UserService userService = Mockito.mock(UserService.class);
		UserDTO e = new UserDTO();
		when(userService.registerUser(e)).thenReturn(e);
		UserDTO newUser = userService.registerUser(e);
		assertNotNull(newUser);
	}

	@Test
	public void testGetUserDetailsByUserId() {
		UserService userService = Mockito.mock(UserService.class);
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		UserDTO e = new UserDTO();
		listUserDTO.add(e);
		when(userService.getUserDetailsByUserId(1)).thenReturn(e);
		UserDTO userDTO = userService.getUserDetailsByUserId(1);
		assertNotNull(userDTO);
	}

	@Test
	public void testGetUsers() {
		UserService userService = Mockito.mock(UserService.class);
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		UserDTO e = new UserDTO();
		listUserDTO.add(e);
		when(userService.getUsers()).thenReturn(listUserDTO);
		List<UserDTO> returnedUserList = userService.getUsers();
		assertEquals(1, returnedUserList.size());
	}

}
