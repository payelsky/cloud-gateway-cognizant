package com.springboot.cloudgateway.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
public class Employee {
	

	private int employeeId;
	private String name;
	private String age;
    private String gender;
	private String address;
	private String isActive;
	

}
