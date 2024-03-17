package com.busycoder.employeeapp.service;

import com.busycoder.employeeapp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(int id);
    public Employee addEmployee(Employee employee);
    public String updateEmployee(int id, Employee employee);
    public String deleteEmployee(int id);
}
