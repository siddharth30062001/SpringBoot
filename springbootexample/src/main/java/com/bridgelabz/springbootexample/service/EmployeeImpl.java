package com.bridgelabz.springbootexample.service;

import com.bridgelabz.springbootexample.entity.Employee;
import com.bridgelabz.springbootexample.util.MyDatabase;
import org.springframework.stereotype.Component;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeImpl implements EmployeeService {
    private Connection conn = null;

    @Override
    public boolean addEmployee(Employee emp) throws SQLException {
        if (conn == null) {
            conn = MyDatabase.getConnection();
        }
        MyDatabase.createTable(conn);
        PreparedStatement stmt = conn.prepareStatement("insert into employee values(?,?,?,?,?)");
        stmt.setInt(1, emp.getId());
        stmt.setString(2, emp.getName());
        stmt.setString(4, emp.getCity());
        stmt.setDouble(3, emp.getSalary());
        stmt.setInt(5, emp.getAge());
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        if (conn == null) {
            conn = MyDatabase.getConnection();
        }
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double salary = rs.getDouble("salary");
            String city = rs.getString("city");
            int age = rs.getInt("age");
            employees.add(new Employee(id, name, salary, city, age));
        }
        return employees;
    }


    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        if (conn == null) {
            conn = MyDatabase.getConnection();
        }
        PreparedStatement stmt = conn.prepareStatement("delete from employee where id=?");
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmployee(int id,Employee emp) throws SQLException{

        if (conn == null) {
            conn = MyDatabase.getConnection();
        }
        PreparedStatement stmt = conn.prepareStatement("update employee set name=?,salary=?,city=?,age=? where id=?");
        stmt.setString(1,emp.getName());
        stmt.setDouble(2,emp.getSalary());
        stmt.setString(3,emp.getCity());
        stmt.setInt(4,emp.getAge());
        stmt.setInt(5,emp.getId());
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {

            return true;
        }
        return false;

    }
}

