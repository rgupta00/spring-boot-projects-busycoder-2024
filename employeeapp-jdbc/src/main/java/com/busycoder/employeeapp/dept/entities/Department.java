package com.busycoder.employeeapp.dept.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dept_table")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int noOfEmployees;

    public Department(String name, int noOfEmployees) {
        this.name = name;
        this.noOfEmployees = noOfEmployees;
    }
}
