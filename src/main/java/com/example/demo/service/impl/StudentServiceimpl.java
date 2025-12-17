package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceimpl implements StudentService{
    @Autowired
    @StudentRepo
    @override
    public Student insertStudent(Student st){
        return StudentRepo.save(st);
    }
    @override
    public List<Student> getAllStudents(){
        return StudentRepo.findall(st);
    }
    

}