package com.busycoder.employeeapp;

import com.busycoder.employeeapp.dept.config.DeptDbProp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class
})
@EnableConfigurationProperties(DeptDbProp.class)
public class EmployeeappJpaApplication {


	public static void main(String[] args) {
		SpringApplication.run(EmployeeappJpaApplication.class, args);
	}
}
