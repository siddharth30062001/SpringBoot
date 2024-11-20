package com.employeexample.emp.service;

import com.employeexample.emp.dto.RequestDTO;
import com.employeexample.emp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    RequestDTO addEmployee(RequestDTO requestDTO);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee updateEmployee(int id,Employee emp);

    void deleteEmployeeById(int id);
}
