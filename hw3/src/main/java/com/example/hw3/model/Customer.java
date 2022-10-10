package com.example.hw3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
        private String id;
        private String fullname;
        private String email;
        private long telephone;
    }

