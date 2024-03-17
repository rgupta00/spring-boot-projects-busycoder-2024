package com.busycoder.employeeapp.service;

import com.busycoder.employeeapp.dao.Employee;
import com.busycoder.employeeapp.dao.EmployeeDao;
import com.busycoder.employeeapp.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getById(int id) {
        Employee employee=employeeDao.getById(id);
        if(employee==null)
            throw new EmployeeNotFoundException("employee with id "+id +" is not found");
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public String updateEmployee(int id, Employee employee) {
         employeeDao.updateEmployee(id, employee);
         return "employee record is successfully updated";
    }

    @Override
    public String deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
        return "employee record is successfully deleted";
    }
}
