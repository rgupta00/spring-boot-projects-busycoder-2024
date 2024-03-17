package com.busycoder.employeeapp.dao;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        //i will teach jdbc template how to covert tuple to object
        return  new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
    }
}
