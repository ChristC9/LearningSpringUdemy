package com.chriscode.springrest.rest;

import com.chriscode.springrest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStuds;

    @PostConstruct // used to load the data ... only once when it's being constructed.
    public void loadData(){
        theStuds = new ArrayList<>();
        theStuds.add(new Student("Mario", "Barlotelli"));
        theStuds.add(new Student("John", "Terry"));
        theStuds.add(new Student("Cristiano", "Ronaldo"));
    }


    @GetMapping("students")
    public List<Student> getStudents(){
        return theStuds;
    }

    @GetMapping("students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        System.out.println("Path Variable is " + studentId);

        // check studentId again in list size
        if (studentId>=theStuds.size() || studentId<0){
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }

        return theStuds.get(studentId);
    }



}
