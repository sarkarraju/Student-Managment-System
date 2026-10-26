package com.students.student.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.student.entity.Student;
import com.students.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  // add student
  @PostMapping
  public int addStudent(@RequestBody Student student) {
    return studentService.addStudent(student);
  }

  // get all student
  @GetMapping
  public List<Student> getAllStudent() {
    return studentService.getAllStudents();
  }

// get student by ID
@GetMapping("/{id}")
public Student getStudentById(@PathVariable int id) {

    return studentService.getStudentById(id);
}



    // =========================
    // Update student
    // =========================

    @PutMapping("/{id}")
    public int updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        student.setId(id);

        return studentService.updateStudent(student);
    }


    // =========================
    // Delete student
    // =========================

    @DeleteMapping("/{id}")
    public int deleteStudent(@PathVariable int id) {

        return studentService.deleteStudent(id);
    }





}
