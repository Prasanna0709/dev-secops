package com.example.prasanna.swagger_docs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity {

    private String id;
    private String name;
    private String email;
    private String department;
    private int year;
}
