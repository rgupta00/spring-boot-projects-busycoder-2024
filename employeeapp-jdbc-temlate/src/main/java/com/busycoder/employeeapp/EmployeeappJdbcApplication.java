package com.busycoder.employeeapp;

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
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeappJdbcApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args) -> {
				if(dataSource!=null){
					System.out.println("ds is created...");
				}

			if(jdbcTemplate!=null){
				System.out.println("jdbcTemplate is created...");
			}

		};
	}
}
