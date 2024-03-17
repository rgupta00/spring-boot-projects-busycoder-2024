package com.busycoder.employeeapp.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager em;

    @Autowired
    public EmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getAll() {
        return em.createQuery("select e from Employee e",Employee.class)
                .getResultList();
    }

    @Override
    public Employee getById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        em.persist(employee);
        return employee;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {

        Employee employeeToUpdate= getById(id);
        employeeToUpdate.setSalary(employee.getSalary());
        em.merge(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employeeToDelete= getById(id);
        em.remove(employeeToDelete);
    }
}
