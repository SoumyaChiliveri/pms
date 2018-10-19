package com.cognizant.osp.fsd.pms.policymanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.osp.fsd.pms.policymanagement.dto.PolicyDTO;
import com.cognizant.osp.fsd.pms.policymanagement.repository.PolicyRepository;
import com.cognizant.osp.fsd.pms.policymanagement.service.PolicyService;

public class PolicyServiceTest {

	
	@Mock
	PolicyRepository policyRepository;
	
	@Test
	public void testGetAllPoliciesForUser() {
		PolicyService policyService = Mockito.mock(PolicyService.class);
		List<PolicyDTO> listPolicyDTO = new ArrayList<PolicyDTO>();
		PolicyDTO e = new PolicyDTO();
		listPolicyDTO.add(e);
		when(policyService.getAllPoliciesForUser("user1")).thenReturn(listPolicyDTO);
		List<PolicyDTO> returnedPolicyList = policyService.getAllPoliciesForUser("user1");
		assertEquals(1, returnedPolicyList.size());
	}

	@Test
	public void testGetAllPolicies() {
		PolicyService policyService = Mockito.mock(PolicyService.class);
		List<PolicyDTO> listPolicyDTO = new ArrayList<PolicyDTO>();
		PolicyDTO e = new PolicyDTO();
		listPolicyDTO.add(e);
		when(policyService.getAllPolicies()).thenReturn(listPolicyDTO);
		List<PolicyDTO> returnedPolicyList = policyService.getAllPolicies();
		assertEquals(1, returnedPolicyList.size());
	}

}
