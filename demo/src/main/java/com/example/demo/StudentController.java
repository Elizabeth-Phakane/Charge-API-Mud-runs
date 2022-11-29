package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;


@RestController
public class StudentController  {

    //arraylist to store students
    ArrayList<StudentRequest> studentList = new ArrayList<>();

    @GetMapping("/")
    public String hello(){
        return "This is the get method";
    }

    @DeleteMapping("/")
    public String methodtwo(){
        return "This is delete method";}

    @PostMapping("/add")
    public String methodthree(@RequestParam Integer num1 , @RequestParam Integer num2)
    {
        Integer add = num1 + num2;
        return "This is the result " + add;}


    @PostMapping("/multiple")
    public String methodtfive(@RequestParam Integer num1 , @RequestParam Integer num2)
    {
        Integer multiply = num1 * num2;
        return "This is the result " + multiply;}

    @PutMapping("/")
    public String methodfour(){
        return "This is put method";}

    //Add a new student to the arraylist
    @PostMapping("/addstudent")
    public StudentResponse addStudent  (@RequestBody StudentRequest studentRequest) {
        studentList.add(studentRequest);
        System.out.println("Name "+ studentRequest.studentName);
        StudentResponse response =new StudentResponse();
        response.setResult("FAILED");
        response.setSubject("MATH");
        return response;
    }


    //Selecting all the student from the arraylist
    @GetMapping("/allstudents")
    public ArrayList<StudentRequest> student () {
        return studentList;
    }



   //Deleting a specific student using the studentID
    @DeleteMapping("/deletestudent/{studentID}")
    public String deleteStudent(@PathVariable int studentID){
        String result ="";
        for(StudentRequest student : studentList){
            if(student.getStudentID() == studentID){
                studentList.remove(student);
                result = "student deleted";
            } else {
                result = "Sorry, student not found";
            }
        }

        return result;
    }


    //Retrieving a single student from the arraylist using the studentID
    @GetMapping("/getstudent/{studentID}")
    public StudentRequest getStudent(@PathVariable int studentID){
    StudentRequest tempStudent = null;
    for(StudentRequest student: studentList){
        if(student.getStudentID() == studentID){
            tempStudent = student;

        }
    }

    return tempStudent;
}


//Updating the values of a student
@PutMapping("/updatestudent")
public StudentRequest updateStudent( @RequestBody StudentRequest reqStudent){

    for(StudentRequest student: studentList){
        if(student.getStudentID() == student.getStudentID()){
            student.setStudentName(reqStudent.getStudentName());
            student.setStudentSurname(reqStudent.getStudentSurname());
            student.setAddress(reqStudent.getAddress());
            student.setEmail(reqStudent.getEmail());

            reqStudent = student;

        }
    }

    return reqStudent;
}





}



