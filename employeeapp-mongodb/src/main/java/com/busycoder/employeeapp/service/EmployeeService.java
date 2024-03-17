package com.busycoder.employeeapp.service;

import com.busycoder.employeeapp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(String id);
    public Employee addEmployee(Employee employee);
    public String updateEmployee(String id, Employee employee);
    public String deleteEmployee(String id);
}
