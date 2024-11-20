package com.bridgelabz.springbootexample.controller;

import com.bridgelabz.springbootexample.entity.Employee;
import com.bridgelabz.springbootexample.service.EmployeeImpl;
import com.bridgelabz.springbootexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MyControl {

    @Autowired
    EmployeeImpl employeeService;

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String message(){
//        return "Hello Siddharth";
//    }

    //PathVariable
//    @RequestMapping(value = "/home/{name}", method = RequestMethod.GET)
//    public String message1(@PathVariable String name){
//        return "Message is: "+name;
//    }
//
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String message2(@RequestParam String fname,@RequestParam String lname){
//
//        return fname+lname;
//    }

    //@RequestBody
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Employee addEmployee(@RequestBody Employee employee){
//        return employee;
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addEmployee(@RequestBody Employee emp) throws SQLException {
       return employeeService.addEmployee(emp);
    }

    @RequestMapping(value="/get", method = RequestMethod.GET)
    public List<Employee> getEmployees() throws SQLException {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    public boolean deleteEmployee(@RequestParam int id) throws SQLException {
        return employeeService.deleteEmployee(id);
    }

    @RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
    public boolean updateEmployee(@PathVariable int id,@RequestBody Employee emp) throws SQLException{
        return employeeService.updateEmployee(id,emp);
    }
}

