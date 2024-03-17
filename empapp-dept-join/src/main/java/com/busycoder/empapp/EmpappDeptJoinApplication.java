package com.busycoder.empapp;

import com.busycoder.empapp.entities.Department;
import com.busycoder.empapp.entities.Employee;
import com.busycoder.empapp.repositories.DeptRepo;
import com.busycoder.empapp.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmpappDeptJoinApplication {

	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private DeptRepo deptRepo;

	public static void main(String[] args) {
		SpringApplication.run(EmpappDeptJoinApplication.class, args);
	}

	//@Bean
	public CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Department d1=new Department("fin");
				Department d2=new Department("IT");
				Department d3=new Department("sales");

				Employee emp1=new Employee("ravi", 6000.00, d1);
				Employee emp2=new Employee("ekta", 4000.00, d1);

				Employee emp3=new Employee("keshav", 7000.00, d2);
				Employee emp4=new Employee("gunika", 3400.00, d2);

				Employee emp5=new Employee("raj", 7800.00, d3);

				//dept 1 have 1,2 emps
				d1.getEmployees().add(emp1);
				d1.getEmployees().add(emp2);


				d2.getEmployees().add(emp3);
				d2.getEmployees().add(emp4);

				d3.getEmployees().add(emp5);

				emp1.setDepartment(d1);
				emp2.setDepartment(d1);

				emp3.setDepartment(d2);
				emp4.setDepartment(d2);

				emp5.setDepartment(d3);

				deptRepo.save(d1);
				deptRepo.save(d2);
				deptRepo.save(d3);

//				employeeRepo.save(emp1);
//				employeeRepo.save(emp2);
//				employeeRepo.save(emp3);
//				employeeRepo.save(emp4);
			//	employeeRepo.save(emp5);
			}
		};
	}
}
