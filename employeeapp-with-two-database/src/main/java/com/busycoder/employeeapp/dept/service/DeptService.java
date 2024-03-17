package com.busycoder.employeeapp.dept.service;

import com.busycoder.employeeapp.dept.entities.Department;

import java.util.List;

public interface DeptService {
    public List<Department> getAll();
    public Department addDept(Department department);

}
