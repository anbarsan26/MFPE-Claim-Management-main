package com.mfpe.memberService;


import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.mfpe.memberService.model.Bills;
import com.mfpe.memberService.repository.BillsRepo;

@SpringBootApplication
@EnableFeignClients

public class MemberServiceApplication  implements CommandLineRunner{
	@Autowired
	private BillsRepo billRepo;
	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	Bills bill1=new Bills("M101","P101",Date.valueOf("2022-05-21"),90000,7000,Date.valueOf("2022-10-21")); 
	Bills bill2=new Bills("M102","P102",Date.valueOf("2022-02-10"),5000,500,Date.valueOf("2022-05-10")); 
	Bills bill3=new Bills("M103","P103",Date.valueOf("2022-04-20"),19000,0,Date.valueOf("2022-05-30")); 
	Bills bill4=new Bills("M104","P102",Date.valueOf("2022-06-05"),21000,0,Date.valueOf("2022-08-10")); 
	ArrayList<Bills> list=new ArrayList<Bills>();
	list.add(bill1);
	list.add(bill2);
	list.add(bill3);
	list.add(bill4);
	billRepo.saveAll(list);
	}
	

}
