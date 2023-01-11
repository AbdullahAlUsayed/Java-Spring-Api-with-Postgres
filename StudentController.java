package com.example.srudent_info.controller;

import com.example.srudent_info.exception.ResourceNotFoundException;
import com.example.srudent_info.model.Student;
import com.example.srudent_info.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    // get all student
    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    // create student rest api
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
       return studentRepository.save(student);
    }
    // get student by id rest api
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
        return ResponseEntity.ok(student);
    }
    // update student rest api

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));

        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        student.setMobile(studentDetails.getMobile());
        student.setGender(studentDetails.getGender());


        Student updateStudent = studentRepository.save(student);
        return ResponseEntity.ok(updateStudent);
    }
    // delete student rest api
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
