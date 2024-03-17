package com.busycoder.employeeapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private DataSource dataSource;

    @Autowired
    public EmployeeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeesList=new ArrayList<>();

        try( Connection connection=dataSource.getConnection()){
            PreparedStatement pstmt=connection.prepareStatement("select * from employee_table");
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                employeesList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return employeesList;
    }

    @Override
    public Employee getById(int id) {
        Employee employee=null;
        try( Connection connection=dataSource.getConnection()){
            PreparedStatement pstmt=connection.prepareStatement("select * from employee_table where id=?");
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
             employee=  new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {

        try( Connection connection=dataSource.getConnection()){
            PreparedStatement pstmt=
                    connection.prepareStatement("insert into employee_table(name,salary) values(?,?)",
                            Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, employee.getName());
            pstmt.setDouble(2, employee.getSalary());
            pstmt.executeUpdate();

            ResultSet rs=pstmt.getGeneratedKeys();
            if(rs.next()){
                employee.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try( Connection connection=dataSource.getConnection()){
            PreparedStatement pstmt=
                    connection.prepareStatement("update employee_table set salary =? where id=?");

            pstmt.setDouble(1, employee.getSalary());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try( Connection connection=dataSource.getConnection()){
            PreparedStatement pstmt=
                    connection.prepareStatement("delete from employee_table where id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
