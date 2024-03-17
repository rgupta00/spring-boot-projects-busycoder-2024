package com.busycoder.empapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "emp_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    private String name;
    private double salary;

    @JsonBackReference
    @JoinColumn(name = "did_fk")
    @ManyToOne
    private Department department;

    public Employee(String name, double salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
