package com.busycoder.empapp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "dept_table")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;
    private String dname;

    @JsonManagedReference //many to one side
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department",
            fetch = FetchType.LAZY)
    private List<Employee> employees=new ArrayList<>();

    public Department(String dname) {
        this.dname = dname;
    }
}
