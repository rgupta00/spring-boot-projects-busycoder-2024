package com.busycoder.empapp.repositories;

import com.busycoder.empapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    //give me all employees in selected ids 1,7
    @Query("select e from Employee e where e.eid in (:eid)")
    public List<Employee> findEmployeeByIds(@Param("eid") List<Integer> eid);
}
