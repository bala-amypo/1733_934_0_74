package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student postStd(@RequestBody Student st) {
        return studentService.insertStudent(st);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> get(@PathVariable Long id) {
        return studentService.getOneStudent(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Student newStudent) {
        Optional<Student> student = studentService.getOneStudent(id);
        if (student.isPresent()) {
            newStudent.setId(id);
            studentService.insertStudent(newStudent);
            return "Updated Success";
        }
        return "Id not found";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getOneStudent(id);
        if (student.isPresent()) {
            studentService.deleteStudent(id);
            return "Deleted Success";
        }
        return "Id Not Found";
    }
}
