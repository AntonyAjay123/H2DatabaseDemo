package com.example.eventUser.service;

import com.example.eventUser.model.Student;
import com.example.eventUser.repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student){
        JSONObject json = new JSONObject(student);
        Student existingStudent = getStudentById(student.getId());
        if(json.has("firstName"))
            existingStudent.setFirstName(student.getFirstName());
        if(json.has("lastName"))
            existingStudent.setLastName(student.getLastName());
        if(json.has("age"))
            existingStudent.setAge(student.getAge());
        if(json.has("department"))
            existingStudent.setDepartment(student.getDepartment());
        studentRepository.save(existingStudent);
    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
}
