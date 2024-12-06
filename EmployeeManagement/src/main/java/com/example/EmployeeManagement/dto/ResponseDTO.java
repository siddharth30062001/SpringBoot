package com.example.EmployeeManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private int id;
    private String fName;
    private String lName;
    private double salary;
    private String profilePic;
    private String department;
    private LocalDate doj;
    private String notes;
    private String gender;

}
