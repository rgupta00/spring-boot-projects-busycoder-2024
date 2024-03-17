package com.busycoder.employeeapp;

import com.busycoder.employeeapp.config.DbProp;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class
})
@EnableConfigurationProperties(DbProp.class)
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
