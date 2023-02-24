package com.example.eventUser.controller;

import com.example.eventUser.model.Student;
import com.example.eventUser.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/getAllStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudent")
    public Student getById(@RequestParam int id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("Successfully added", HttpStatus.CREATED);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Successfully updated",HttpStatus.ACCEPTED);
    }

}
