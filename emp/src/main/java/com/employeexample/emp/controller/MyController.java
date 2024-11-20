package com.employeexample.emp.controller;

import com.employeexample.emp.dto.RequestDTO;
import com.employeexample.emp.entity.Employee;
import com.employeexample.emp.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    private EmployeeServiceImpl employeeServiceImpl;

    //Dependency injection using constructor
    public MyController(EmployeeServiceImpl employeeService){
        this.employeeServiceImpl = employeeService;
    }

    @PostMapping(value = "/add")
    public  RequestDTO addEmployee(@RequestBody RequestDTO requestDTO){

        return employeeServiceImpl.addEmployee(requestDTO);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){

        return employeeServiceImpl.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return employeeServiceImpl.updateEmployee(id,emp);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){

         employeeServiceImpl.deleteEmployeeById(id);
    }
}
