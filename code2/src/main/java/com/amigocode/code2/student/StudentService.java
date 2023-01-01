package com.amigocode.code2.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return  studentRepository.findAll();


    }

    public void addNEwStudent(Student student) {
       Optional<Student> studentByEmail=
               studentRepository.findStudentByEmail(student.getEmail());
   if(studentByEmail.isPresent()){
       throw  new IllegalStateException("email taken");
   }
       studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exits=studentRepository.existsById(id);
        if(!exits){
            throw  new IllegalStateException(
                    "student with id"+id+"does not exits");

        }

        studentRepository.deleteById(id);
    }
    @Transactional
    public  void updateStudent(Long id,String name,String email){
        Student student=studentRepository.findById(id).orElseThrow(()-> new IllegalStateException(

                "student with id"+id+"does nor exits"
                )
        );
    if(name !=null&&name.length()>0 &&!Objects.equals(student.getName(),name)){
        student.setName(name);
    }
    if (email!=null&&email.length()>0&&!Objects.equals(student.getEmail(),email)){
        student.setEmail(email);
        }

    }
}