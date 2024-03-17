package com.busycoder.empapp.controller;

import com.busycoder.empapp.dto.EmpDeptResponse;
import com.busycoder.empapp.entities.Department;
import com.busycoder.empapp.exceptions.ResouceNotFoundException;
import com.busycoder.empapp.repositories.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptRepo deptRepo;

    @GetMapping(path = "departments")
    public List<Department> getAll(){
        return deptRepo.findAll();
    }

    @GetMapping(path = "departments/{id}")
    public Department getById(@PathVariable int id){
        return deptRepo.findById(id).orElseThrow(()->new ResouceNotFoundException("dept with id "+id+" is not found"));
    }

    //deptEmpInformation
    @GetMapping(path = "deptEmpInformation")
    public List<EmpDeptResponse> deptEmpInformation(){
        return deptRepo.deptEmpInformation();
    }

}
