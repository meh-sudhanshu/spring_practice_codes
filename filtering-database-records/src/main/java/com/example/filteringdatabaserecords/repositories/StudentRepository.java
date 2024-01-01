package com.example.filteringdatabaserecords.repositories;

import com.example.filteringdatabaserecords.models.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long>, JpaSpecificationExecutor<Student> {
}
