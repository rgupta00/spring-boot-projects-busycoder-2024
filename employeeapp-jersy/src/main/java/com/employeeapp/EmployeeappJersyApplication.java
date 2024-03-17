package com.employeeapp;

import com.employeeapp.entities.Employee;
import com.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeappJersyApplication {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeappJersyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		System.out.println("---------------------");
		return (args) -> {
				employeeService.addEmployee(new Employee("raj",450000));
				employeeService.addEmployee(new Employee("amit",450000));
		};
	}
}
