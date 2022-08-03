package com.policy.microservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.policy.microservice.repository.BenefitsRepo;

@SpringBootTest
public class BenefitsServiceTest {
	@Autowired
	BenefitsService benefitService;
	@MockBean
	BenefitsRepo benefitsRepo;
	
	@Test
	@DisplayName("Checking if BenefitsService class is loaded or not")
	void benefitsServiceLoadedOrNot() {
		assertThat(benefitService).isNotNull();
	}
}
