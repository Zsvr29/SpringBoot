package com.amigocode.code2.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentControlller {

    private  final StudentService studentService;

    @Autowired
    public StudentControlller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping

    public List<Student> getStudents() {

        return  studentService.getStudents();
    }
    @PostMapping
    public void registerStudent(@RequestBody Student student){
        studentService.addNEwStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping(path = "{studentId}")

    public void updateStudent(
        @PathVariable("student")Long id,
        @RequestParam (required = false) String name,
        @RequestParam(required = false) String email){
        studentService.updateStudent(id,name,email);
    }

    }



