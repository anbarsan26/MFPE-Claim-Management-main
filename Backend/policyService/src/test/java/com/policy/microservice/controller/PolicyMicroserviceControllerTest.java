package com.policy.microservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.policy.microservice.dto.ValidatingDTO;
import com.policy.microservice.exception.InvalidTokenException;
import com.policy.microservice.service.BenefitsService;
import com.policy.microservice.service.ClaimAmountService;
import com.policy.microservice.feign.AuthClient;
@SpringBootTest
class ClaimsControllerTest {

	@Autowired
	PolicyMicroserviceController policyMicroserviceController;
	@MockBean
	BenefitsService benefitsService;
	@MockBean
	ClaimAmountService claimAmountService;
	@MockBean
	AuthClient authClient;
	
	@Test
    @DisplayName("Checking for Claims Controller - if it is loading or not for @GetMapping")
    void componentProcessingControllerNotNullTest(){
        assertThat(policyMicroserviceController).isNotNull();
    }
	
	@Test
	@DisplayName("Checking getchainofproviders Endpoint with Invalid Token")
	void testGetChainOfProvidersEndpointWithInvalidToken() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		
		assertThrows(InvalidTokenException.class, () ->
		policyMicroserviceController.getChainOfProviders("C101",token));
	}
	
}
