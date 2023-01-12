package com.example.service;

import com.example.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface StudentService {

        ArrayList<Student> findAllStudents();
        Student findAllStudentByID(Integer student_id);
        void addStudent();
        void deleteAllData();


}
