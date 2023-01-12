package com.example.controller;

import java.util.ArrayList;
import com.example.entity.Student;
import com.example.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {


    @Autowired
    StudentServiceImp studentServiceImp;

    @PostMapping("/addstudent")
    public void add() {
        studentServiceImp.addStudent();
    }

    @GetMapping("/findall")
    public ArrayList<Student> getAllStudent() {
        return studentServiceImp.findAllStudents();
    }

    @GetMapping("/findbyid/{student_id}")
    public Student getEmployeeUsingId(@PathVariable Integer student_id) {
        return studentServiceImp.findAllStudentByID(student_id);
    }

    @DeleteMapping("/delete")
    public void delete() {
        studentServiceImp.deleteAllData();
    }
}
