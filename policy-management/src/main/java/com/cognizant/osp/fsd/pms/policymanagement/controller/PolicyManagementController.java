package com.cognizant.osp.fsd.pms.policymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.osp.fsd.pms.policymanagement.dto.PolicyDTO;
import com.cognizant.osp.fsd.pms.policymanagement.dto.UserDTO;
import com.cognizant.osp.fsd.pms.policymanagement.dto.UserInfo;
import com.cognizant.osp.fsd.pms.policymanagement.service.PolicyService;
import com.cognizant.osp.fsd.pms.policymanagement.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/policy-management")
public class PolicyManagementController {

	@Autowired
	private UserService userService;
	@Autowired
	private PolicyService policyService;
	
	
	
	@RequestMapping(method=RequestMethod.POST,path="/users/login" , produces = "application/json")
	@ApiOperation(value = "/users/login", nickname = "login")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userInfo", required = false, dataType = "UserInfo", paramType = "body")
      })
	@CrossOrigin
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	public UserDTO userLogin(@RequestBody UserInfo userInfo) {
		return userService.loginUSer(userInfo.getUsername(), userInfo.getPassword());
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/users/{userId}" , produces = "application/json")
	@ApiOperation(value = "/users/{userId}", nickname = "user")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", required = true, dataType = "string", paramType = "path")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = UserDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	@CrossOrigin
	public UserDTO getUserDetailsById(@PathVariable(value="userId") Integer userId) {
		return userService.getUserDetailsByUserId(userId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/users" , produces = "application/json")
	@ApiOperation(value = "/users", nickname = "user")
    @CrossOrigin
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	public List<UserDTO> getAllUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/users" , produces = "application/json")
	@ApiOperation(value = "/users", nickname = "users")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userDTO", required = false, dataType = "UserDTO", paramType = "body")
      })
	@CrossOrigin
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	public UserDTO registerUser(@RequestBody UserDTO userDTO) {
		return userService.registerUser(userDTO);
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.GET,path="/users/{username}/policies/", produces = "application/json")
	@ApiOperation(value = "/users/{username}/policies/", nickname = "policy")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", required = true, dataType = "String", paramType = "path")
        
      })
	@CrossOrigin
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	public List<PolicyDTO> getPoliciesForUSer(@PathVariable(value="username") String username) {
		return policyService.getAllPoliciesForUser(username);
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET,path="/policies/", produces = "application/json")
	@ApiOperation(value = "/policies/", nickname = "policy")
	@CrossOrigin
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	public List<PolicyDTO> getAllPolicies() {
		return policyService.getAllPolicies();
		
	}
	
	
	
}
