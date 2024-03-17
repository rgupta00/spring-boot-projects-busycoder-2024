package com.busycoder.employeeapp.service;

import com.busycoder.employeeapp.entities.Employee;
import com.busycoder.employeeapp.repo.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getById(String id) {
        return employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("employee not found"));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public String updateEmployee(String id, Employee employee) {
        Employee employeeToUpdate=getById(id);
        employeeToUpdate.setSalary(employee.getSalary());
        employeeRepo.save(employeeToUpdate);
        return "employee is updated";
    }

    @Override
    public String deleteEmployee(String id) {
        Employee employeeToDelete=getById(id);
        employeeRepo.delete(employeeToDelete);

        return "employee is deleted";
    }
}
