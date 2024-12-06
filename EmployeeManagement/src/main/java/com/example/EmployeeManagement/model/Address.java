package com.example.EmployeeManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long address_id;

        private String houseNo;
        private String street;
        private String city;
        private String state;
        private String zipCode;

        @ManyToOne(fetch = FetchType.LAZY)
        @JsonIgnore
        private Employee employee;

    }

