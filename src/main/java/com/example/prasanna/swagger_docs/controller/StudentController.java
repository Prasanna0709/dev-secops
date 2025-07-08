package com.example.prasanna.swagger_docs.controller;

import com.example.prasanna.swagger_docs.dto.StudentDto;
import com.example.prasanna.swagger_docs.entity.StudentEntity;
import com.example.prasanna.swagger_docs.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(
        name = "Student Apis",
        description = "Rest Apis for creating , deleting , updating , fetching students "
)
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @Operation(
            parameters = {
                    @Parameter(name = "Auth-Header",description = "normal Auth header",required = true,in = ParameterIn.HEADER)
            }
    )
    @ApiResponses(
         value = {
                 @ApiResponse(responseCode = "201",description = "Successfully student saved"),
                 @ApiResponse(responseCode = "400",description = "Bad request email field is empty")
         }
    )
    public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable String id){
        return studentService.getStudent(id);
    }

}
