package com.busycoder.employeeapp.service;

import com.busycoder.employeeapp.entities.Employee;
import com.busycoder.employeeapp.exceptions.EmployeeNotFoundException;
import com.busycoder.employeeapp.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Employee getById(int id) {
        Employee employee=employeeRepo
                .findById(id).orElseThrow(()-> new EmployeeNotFoundException("employee with id "+id +" is not found"));
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public String updateEmployee(int id, Employee employee) {
        Employee employeeToUpdate=getById(id);
        employeeToUpdate.setSalary(employee.getSalary());
        employeeRepo.save(employeeToUpdate);
         return "employee record is successfully updated";
    }

    @Override
    public String deleteEmployee(int id) {
        Employee employeeToDelete=getById(id);
        employeeRepo.delete(employeeToDelete);
        return "employee record is successfully deleted";
    }
}
