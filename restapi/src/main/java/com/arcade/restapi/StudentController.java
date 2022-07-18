package com.arcade.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentRepository repository;

    StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    List<StudentModel> getStudents() {
        return repository.findAll();
    }

    @PostMapping("/students")
    StudentModel createStudent(@RequestBody StudentModel newStudent) {
        return repository.save(newStudent);
    }

    @GetMapping("/students/{id}")
    Optional<StudentModel> getOneStudent(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/students/{id}")
    Optional<Object> updateStudent(@RequestBody StudentModel newStudent, @PathVariable Long id) {
        return repository.findById(id).map(student -> {
            student.setName(newStudent.getName());
            student.setAge(newStudent.getAge());
            return repository.save(student);
        });
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
