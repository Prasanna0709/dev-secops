package com.example.prasanna.swagger_docs.services;

import com.example.prasanna.swagger_docs.dto.StudentDto;
import com.example.prasanna.swagger_docs.entity.StudentEntity;
import com.example.prasanna.swagger_docs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public ResponseEntity<String> addStudent(StudentDto studentDto){

        if(studentDto.getEmail()==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        StudentEntity studentEntity = StudentEntity.builder()
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .department(studentDto.getDepartment())
                .year(studentDto.getYear())
                .build();

        studentRepository.save(studentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student saved");
    }


    public ResponseEntity<StudentDto> getStudent(String id){
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        StudentEntity studentEntity = optionalStudentEntity.get();

        return ResponseEntity.status(HttpStatus.OK).body(StudentDto.builder()
                        .id(studentEntity.getId())
                        .name(studentEntity.getName())
                        .department(studentEntity.getDepartment())
                        .year(studentEntity.getYear())
                .build());

    }
}
