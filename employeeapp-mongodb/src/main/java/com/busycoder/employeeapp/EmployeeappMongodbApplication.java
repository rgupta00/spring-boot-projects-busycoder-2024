package com.busycoder.employeeapp;

import com.busycoder.employeeapp.entities.Employee;
import com.busycoder.employeeapp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmployeeappMongodbApplication {

	@Autowired
	private EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeappMongodbApplication.class, args);
	}

	public CommandLineRunner commandLineRunner(){

		return ( args) -> {
				List<Employee> employees=List.of(
						new Employee("amit",70000),
						new Employee("sumit",70000)
				);

				employeeRepo.saveAll(employees);

		};


	}
}
