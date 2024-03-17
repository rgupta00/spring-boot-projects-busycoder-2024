package com.busycoder.employeeapp.emp.service;

import com.busycoder.employeeapp.emp.entities.Employee;
import com.busycoder.employeeapp.emp.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }

}
