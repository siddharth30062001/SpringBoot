package com.employeexample.emp.entity;

import com.employeexample.emp.dto.RequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "emp_data")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double salary;
    private String city;
    private int age;
    private LocalDate doj;

    public Employee(RequestDTO requestDTO) {
        this.name = requestDTO.getName();
        this.salary = requestDTO.getSalary();
        this.city = requestDTO.getCity();
        this.age = requestDTO.getAge();
        this.doj= LocalDate.now();
    }






}
