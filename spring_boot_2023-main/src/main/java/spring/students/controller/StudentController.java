package spring.students.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.students.model.Student;
import spring.students.repository.StudentRepository;
import spring.students.service.StudentService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService service;
    private final StudentRepository repository;

    @GetMapping
    public List<Student> findAllStudent() {

        return service.findAllStudent();
    }

    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
        return "Student successfully saved";
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
    // /api/v1/students/oleg12@gmail.com

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id){
       repository.findStudentById(id);
       return "User findById";
    }


    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        service.deleteStudent(email);
    }
}
