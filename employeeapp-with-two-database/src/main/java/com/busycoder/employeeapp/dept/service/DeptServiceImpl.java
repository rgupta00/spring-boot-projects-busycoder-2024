package com.busycoder.employeeapp.dept.service;

import com.busycoder.employeeapp.dept.entities.Department;
import com.busycoder.employeeapp.dept.repo.DeptRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DeptServiceImpl implements DeptService{

    private DeptRepo deptRepo;

    public DeptServiceImpl(DeptRepo deptRepo) {
        this.deptRepo = deptRepo;
    }

    @Override
    public List<Department> getAll() {
        return deptRepo.findAll();
    }

    @Override
    public Department addDept(Department department) {
        deptRepo.save(department);
        return department;
    }
}
