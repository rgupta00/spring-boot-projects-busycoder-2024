package com.busycoder.empapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDeptResponse {
    private String dname;
    private String name;
    private double salary;
}
