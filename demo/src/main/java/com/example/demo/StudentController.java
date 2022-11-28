package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;



import java.util.ArrayList;


@RestController
public class StudentController  {

   // StudentRequest s1 = new StudentRequest("2","Sam","P","V","S");
    ArrayList<StudentRequest> studentList = new ArrayList<>();
    StudentRequest s1 = new StudentRequest();






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


    @PostMapping("/addstudent")
    public StudentResponse addStudent  (@RequestBody StudentRequest studentRequest) {
        studentList.add(studentRequest);
        System.out.println("Name "+ studentRequest.studentName);
        StudentResponse response =new StudentResponse();
        response.setResult("FAILED");
        response.setSubject("MATH");
        return response;
    }

    @GetMapping("/allstudents")
    public ArrayList<StudentRequest> student () {
        return studentList;
    }



    @DeleteMapping("/deletestudent/{studentID}")
    public void deleteStudent (@PathVariable String studentID){

        StudentRequest result = studentList.get(Integer.parseInt(studentID));
        System.out.println("The index is "+ result);
       //studentList.get(Integer.parseInt(studentID));

        studentList.remove(result);


    }





}



