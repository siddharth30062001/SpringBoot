package com.bridgelabz.springbootexample.service;
import com.bridgelabz.springbootexample.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {

    public boolean addEmployee(Employee employee) throws SQLException;

    public List<Employee> getAllEmployees() throws SQLException;

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(int id,Employee employee)throws SQLException;
}
