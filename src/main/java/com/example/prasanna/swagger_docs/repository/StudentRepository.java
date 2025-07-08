package com.example.prasanna.swagger_docs.repository;

import com.example.prasanna.swagger_docs.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentEntity,String> {
}
