package com.busycoder.employeeapp.dao;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAll();
    public Employee getById(int id);
    public Employee addEmployee(Employee employee);
    public void updateEmployee(int id, Employee employee);
    public void deleteEmployee(int id);
}
