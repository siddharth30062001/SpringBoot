package com.example.EmployeeManagement.controller;


import com.example.EmployeeManagement.dto.RequestDTO;
import com.example.EmployeeManagement.dto.ResponseDTO;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.service.EmailService;
import com.example.EmployeeManagement.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmailService emailService;

    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public RequestDTO addEmployee( @Valid @RequestBody RequestDTO requestDTO){
        //method used to send mail to the client
        emailService.sendEmail(requestDTO.getEmail(),"Message","Thank you for registration");
        return employeeService.addEmployeeData(requestDTO);
    }

    @GetMapping("/get")
    public List<ResponseDTO> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public ResponseDTO getEmployeeById(@PathVariable int id){

        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable int id){

        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("update/{id}")
    public RequestDTO updateEmployee(@PathVariable int id, @RequestBody RequestDTO emp){

        return employeeService.updateEmployeeById(id,emp);
    }
}
