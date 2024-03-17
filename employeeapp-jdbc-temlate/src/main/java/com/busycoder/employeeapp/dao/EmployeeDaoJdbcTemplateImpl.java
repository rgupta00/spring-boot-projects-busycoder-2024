package com.busycoder.employeeapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
@Primary
public class EmployeeDaoJdbcTemplateImpl implements EmployeeDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query("select * from employee_table", new EmployeeRowMapper());
    }

    @Override
    public Employee getById(int id) {
        return jdbcTemplate.queryForObject("select * from employee_table where id=?",
                new EmployeeRowMapper(), id);
    }

    @Override
    public Employee addEmployee(Employee employee) {

        KeyHolder keyHolder=new GeneratedKeyHolder();
        String update_query="insert into employee_table(name,salary) values(?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt=con.prepareStatement(update_query, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, employee.getName());
                pstmt.setDouble(2, employee.getSalary());
              //  pstmt.executeUpdate();
                return pstmt;
            }
        }, keyHolder);

        //Extract that key for keyholder
        int key= keyHolder.getKey().intValue();
        employee.setId(key);
        return employee;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        jdbcTemplate.update("update employee_table set salary =? where id=?",
                new Object[]{employee.getSalary(), id});
    }

    @Override
    public void deleteEmployee(int id) {
        jdbcTemplate.update("delete from employee_table where id=?", id);
    }
}
