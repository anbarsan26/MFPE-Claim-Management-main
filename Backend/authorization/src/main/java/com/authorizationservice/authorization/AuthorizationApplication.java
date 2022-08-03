package com.authorizationservice.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.repository.AuthRequestRepo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class AuthorizationApplication implements CommandLineRunner{
	
	@Autowired
	AuthRequestRepo authRequestRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		AuthenticationRequest user1 = new AuthenticationRequest("Anbarasan","12345");
		AuthenticationRequest user2 = new AuthenticationRequest("Sowmya","12345");
		AuthenticationRequest user3 = new AuthenticationRequest("Rachana","12345");
		AuthenticationRequest user4 = new AuthenticationRequest("Sagar","12345");
		AuthenticationRequest user5 = new AuthenticationRequest("Vinodha","12345");
		authRequestRepo.save(user1);
		authRequestRepo.save(user2);
		authRequestRepo.save(user3);
		authRequestRepo.save(user4);
		authRequestRepo.save(user5);
	}

}