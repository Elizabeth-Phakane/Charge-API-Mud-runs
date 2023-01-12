package com.example.service;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepo;

    @Override
    public ArrayList<Student> findAllStudents() {
        return (ArrayList<Student>) studentRepo.findAll();
    }


    @Override
    public Student findAllStudentByID(Integer student_id) {
        Optional<Student> opt = studentRepo.findById(student_id);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public void addStudent() {
        ArrayList<Student> stud = new ArrayList<Student>();
        stud.add(new Student(2, "Sister","Phakane","1970/04/12","Johannesburg",23));

        for (Student student :stud ) {
            studentRepo.save(student);
        }

    }

    @Override
    public void deleteAllData() {

        studentRepo.deleteAll();

    }
}
