package com.busycoder.employeeapp.emp.repo;

import com.busycoder.employeeapp.emp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
