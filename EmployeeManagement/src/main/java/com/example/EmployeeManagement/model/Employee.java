package com.example.EmployeeManagement.model;

import com.example.EmployeeManagement.dto.RequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String fName;
    private String lName;
    private double salary;
    private String profilePic;
    private String department;
    private LocalDate doj;
    private String notes;
    private String gender;

    @ElementCollection
    @CollectionTable(name = "department_data",joinColumns = @JoinColumn(name="employee_id"))
    private List<String> departments;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Address> address;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Laptop laptop;

    public Employee(RequestDTO requestDTO) {
        this.id= requestDTO.getId();
        this.fName= requestDTO.getFName();
        this.lName= requestDTO.getLName();
        this.salary= requestDTO.getSalary();
        this.profilePic=requestDTO.getProfilePic();
        this.department= requestDTO.getDepartment();
        this.doj= requestDTO.getDoj();
        this.notes= requestDTO.getNotes();
        this.gender= requestDTO.getGender();
        this.departments= requestDTO.getDepartments();
        this.laptop= requestDTO.getLaptop();
    }
}
