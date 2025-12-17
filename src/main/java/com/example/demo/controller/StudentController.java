package com.example.demo.controller:
import java.util.List;
import java.util.Ootional;
import org.soringframework.beans.factorv.annotation. Autowired:
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org. springframework.web.bind.annotation.GetMapping;
import org. springframework.web.bind. annotation. PathVariable;
import org. springframework.web.bind.annotation. PostMapping;
import org. springframework.web.bind.annotation. PutMapping;
import org.springframework.wep.bina.annotation.RequestBody;
import org.springframework.wep.bina.annotation.RestControlier;
import com.example.aemo.entity.Stuaent;
import com.example.aemo.service.StuaentService;
@CrossOrigin(origins = "*")
@RestController
public class StudentController {
@Autowired
StudentService studentService;
@PostMapping("/PostStudent")
public Student postStd(@RequestBody Student st){
return studentService.insertStudent(st);
}

@GetMapping("/getAll")
public List<Student> getAll()E|
return studentService.getAllStudents();

@GetMapping("/get/{id}")
public Optional<Student> get(@PathVariable Long id){
return studentService.getOneStudent(id);

@PutMapping("/update/{id}")
public String update(@PathVariable Long id,@RequestBody Student
newStudent){
Optional<Student> student=studentService.getOneStudent(id);
if(student.isPresent()){
newStudent.setId(id);
studentService.insertStudent(newStudent);
return "Updated Success";
3
return "Id not found";
}
return "Id not found";

@DeleteMapping("/del/(id}")
public String deleteStudent(@PathVariable Long id){
Optional<Student> student=studentService.getOneStudent(id);
if(student.isPresent()){
studentService.deleteStudent(id);
return "Deleted Success";
}
return "Id Not Found";
}

