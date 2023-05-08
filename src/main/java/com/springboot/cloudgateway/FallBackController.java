package com.springboot.cloudgateway;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cloudgateway.dto.Employee;
import com.springboot.cloudgateway.dto.EmployeeDetails;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	
	
	@RequestMapping("/hcmFallBack")
	public List<EmployeeDetails> hcmFallBack(@RequestBody  List<Employee> emplist){
		System.out.println("Hi::::::::::::::::::::::::::::::::::");
		List<EmployeeDetails> empdetailslist=emplist.stream().map(emp->EmployeeDetails.build(emp.getEmployeeId(), emp.getName(), emp.getAge(), emp.getGender(), emp.getAddress(), emp.getIsActive(), "DOWN", "DOWN", "DOWN","DOWN"))
                .collect(Collectors.toList());
		
		return empdetailslist;
	}
    
	
	@RequestMapping("/promotionFallBack")
	public Mono<String> promotionFallBack(){
	return Mono.just("Promotion Service is taking too long to respond or is down. Please try again later");	
	}

}
