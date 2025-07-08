package com.example.prasanna.swagger_docs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    private String name;
    private String email;
    private String department;
    private int year;
}
