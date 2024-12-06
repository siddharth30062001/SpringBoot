package com.example.EmployeeManagement.dto;

import com.example.EmployeeManagement.model.Address;
import com.example.EmployeeManagement.model.Laptop;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequestDTO {
    private int id;

    @NotBlank
    private String fName;
    private String lName;
    @NotNull
    private double salary;
    private String profilePic;
    private String department;
    private LocalDate doj;
    private String notes;
    private String gender;

    @Email
    private String email;
    @Min(value = 18, message = "Age must be 18")
    @Max(value = 50, message = "Age limit is 50")
    private int age;

    //YYYY-MM-DD format for localDate
    @Past(message = "BirthDate must be a past date")
    private LocalDate birthDate;

    @Future(message = "Event date must be a future date")
    private LocalDate eventDate;

    @PastOrPresent(message = "Registration date must be past or present date")
    private LocalDate registrationDate;

    @FutureOrPresent
    private LocalDate bookingDate;

    private List<Address> address;

    private List<String> departments;

    private Laptop laptop;

}
