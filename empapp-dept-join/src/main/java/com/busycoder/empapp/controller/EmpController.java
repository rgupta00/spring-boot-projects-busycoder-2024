package com.busycoder.empapp.controller;

import com.busycoder.empapp.dto.EmployeeReq;
import com.busycoder.empapp.entities.Employee;
import com.busycoder.empapp.exceptions.ResouceNotFoundException;
import com.busycoder.empapp.repositories.DeptRepo;
import com.busycoder.empapp.repositories.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmpController {

    private final EmployeeRepo employeeRepo;
    private final  DeptRepo deptRepo;

    //get all employees
    @GetMapping(path = "employees")
    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }
    @GetMapping(path = "employees/{id}")
    public Employee getById(@PathVariable int id){
        return employeeRepo.findById(id)
                .orElseThrow(()-> new ResouceNotFoundException("emp with id "+ id +" is not found"));
    }

    //selected employees
    //findEmployeeByIds
    @GetMapping(path = "selectedemployees")
    public List<Employee>getEmployeeByIds(@RequestBody EmployeeReq employeeReq){
        return  employeeRepo.findEmployeeByIds(employeeReq.getIds());

    }
}
