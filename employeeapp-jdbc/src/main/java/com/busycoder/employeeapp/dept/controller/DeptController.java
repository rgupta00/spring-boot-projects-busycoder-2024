package com.busycoder.employeeapp.dept.controller;

import com.busycoder.employeeapp.dept.entities.Department;
import com.busycoder.employeeapp.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    private DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    //add
    @PostMapping(path = "depts")
    public Department addDept(@RequestBody Department department){
      return   deptService.addDept(department);
    }
    //get all
    @GetMapping(path = "depts")
    public List<Department> getAll(){
        return deptService.getAll();
    }
}
