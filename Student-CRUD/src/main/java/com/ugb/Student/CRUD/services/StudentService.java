package com.ugb.Student.CRUD.services;


import com.ugb.Student.CRUD.exceptions.DuplicateRollNumberException;
import com.ugb.Student.CRUD.models.Student;
import com.ugb.Student.CRUD.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {




    @Autowired
    private StudentRepository studentRepository;

    public Student saveOrUpdate(Student student){

        try
        {
            return  studentRepository.save(student);
        }catch (Exception e){
            throw new DuplicateRollNumberException("Roll number already exists");
        }

    }



}
