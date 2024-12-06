package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.dto.RequestDTO;
import com.example.EmployeeManagement.dto.ResponseDTO;
import com.example.EmployeeManagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    RequestDTO addEmployeeData(RequestDTO requestDTO);

    List<ResponseDTO> getAllEmployees();

    void deleteEmployeeById(int id);

    ResponseDTO getEmployeeById(int id);

    RequestDTO updateEmployeeById(int id, RequestDTO emp);
}
