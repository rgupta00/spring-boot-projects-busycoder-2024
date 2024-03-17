package com.busycoder.employeeapp.emp.controller;

import com.busycoder.employeeapp.emp.entities.Employee;
import com.busycoder.employeeapp.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //---------get all employees-----------
    @GetMapping(path = "employees")
    public List<Employee> getALl(){
        return employeeService.getAll();
    }


    //---------add employee----
    @PostMapping(path = "employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }


}
