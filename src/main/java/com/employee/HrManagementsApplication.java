package com.employee;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.entities.Employee;

@SpringBootApplication
public class HrManagementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrManagementsApplication.class, args);	
	}
    	
}
