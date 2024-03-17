package com.busycoder.employeeapp.repo;

import com.busycoder.employeeapp.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
