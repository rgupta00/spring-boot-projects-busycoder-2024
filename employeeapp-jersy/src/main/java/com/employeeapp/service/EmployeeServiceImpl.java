package com.employeeapp.service;

import com.employeeapp.entities.Employee;
import com.employeeapp.exceptions.ResourceNotFoundException;
import com.employeeapp.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private  final  EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public Employee getById(int id) {
        Employee employee=employeeRepo
                .findById(id).orElseThrow(()-> new ResourceNotFoundException("emp with id "+ id +" is not found"));
        return employee;
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee employeeToUpdate=getById(id);
        employeeToUpdate.setSalary(employee.getSalary());
        employeeRepo.save(employeeToUpdate);
        return employeeToUpdate;
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee employeeToDelete=getById(id);
        employeeRepo.delete(employeeToDelete);
        return employeeToDelete;
    }
}
