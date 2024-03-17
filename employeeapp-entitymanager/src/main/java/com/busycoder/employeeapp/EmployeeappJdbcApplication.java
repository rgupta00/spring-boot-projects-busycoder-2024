package com.busycoder.employeeapp;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class EmployeeappJdbcApplication {

	@Autowired
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeappJdbcApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args) -> {
				if(entityManager!=null){
					System.out.println("entityManager is created...");
				}

		};
	}
}
