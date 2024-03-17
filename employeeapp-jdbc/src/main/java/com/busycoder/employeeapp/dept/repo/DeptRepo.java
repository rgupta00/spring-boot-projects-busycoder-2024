package com.busycoder.employeeapp.dept.repo;

import com.busycoder.employeeapp.dept.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepo extends JpaRepository<Department, Integer> {
}
