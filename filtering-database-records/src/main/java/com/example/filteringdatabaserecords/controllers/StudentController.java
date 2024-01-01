package com.example.filteringdatabaserecords.controllers;


import com.example.filteringdatabaserecords.models.Student;
import com.example.filteringdatabaserecords.repositories.StudentRepository;
import com.example.filteringdatabaserecords.services.StudentService;
import com.example.filteringdatabaserecords.utils.ColumnFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        var savedStudent = studentRepository.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.valueOf(200));
    }

    @PostMapping("/save-all")
    public  ResponseEntity<?> saveAllStudents(@RequestBody List<Student> studentList){
        studentRepository.saveAll(studentList);
        return new ResponseEntity<>("All students are saved",HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<>(studentRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/filtered-students")
    public ResponseEntity<?> getFilteredStudentsList(){

        List<ColumnFilters> includedFilters = new ArrayList<>();
        List<ColumnFilters> excludedFilters = new ArrayList<>();

        ColumnFilters c1 = new ColumnFilters();
        c1.setColumnName("name");
        c1.setValues(Arrays.asList("manisha","sudhanshu"));
        includedFilters.add(c1);


        ColumnFilters c3 = new ColumnFilters();
        c3.setColumnName("section");
        c3.setValues(Arrays.asList("A"));
        excludedFilters.add(c3);


        var filteredStudents = studentService.getFilteredEntities(includedFilters,excludedFilters);
        return new ResponseEntity<>(filteredStudents,HttpStatus.OK);
    }

}
