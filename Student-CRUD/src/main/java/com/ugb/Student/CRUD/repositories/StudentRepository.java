package com.ugb.Student.CRUD.repositories;

import com.ugb.Student.CRUD.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
