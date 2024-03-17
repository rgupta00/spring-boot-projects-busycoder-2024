package com.busycoder.employeeapp.emp.service;

import com.busycoder.employeeapp.emp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee addEmployee(Employee employee);
}
