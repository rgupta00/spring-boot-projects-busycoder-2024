package com.busycoder.employeeapp.controller;

import com.busycoder.employeeapp.entities.Employee;
import com.busycoder.employeeapp.service.EmployeeService;
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

    //---------get employee by id-----------
    @GetMapping(path = "employees/{id}")
    public Employee getById(@PathVariable String id){
        return employeeService.getById(id);
    }

    //---------add employee----
    @PostMapping(path = "employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    //---------update employee-----------
    @PutMapping(path = "employees/{id}")
    public String udpateEmployee(@PathVariable String id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    //--------delete employee-----------
    @DeleteMapping(path = "employees/{id}")
    public String deleteById(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }

}
