package com.busycoder.empapp.repositories;

import com.busycoder.empapp.dto.EmpDeptResponse;
import com.busycoder.empapp.entities.Department;
import com.busycoder.empapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRepo extends JpaRepository<Department, Integer> {
    //dname, ename and salary
    @Query("select new com.busycoder.empapp.dto.EmpDeptResponse(d.dname, e.name, e.salary) from Department d inner join d.employees e")
    public List<EmpDeptResponse>deptEmpInformation();

}

