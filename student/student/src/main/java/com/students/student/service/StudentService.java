package com.students.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.students.student.entity.Student;
import com.students.student.repository.StudentRepository;


@Service 
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
this.studentRepository=studentRepository;
    }
    //add student 
    public int addStudent(Student student){
        return studentRepository.add(student);
    }
   // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }



// Get student by ID
public Student getStudentById(int id) {
    return studentRepository.getById(id);
}


    // Update student
    public int updateStudent(Student student) {
        return studentRepository.update(student);
    }


    // Delete student
    public int deleteStudent(int id) {
        return studentRepository.delete(id);
    }

}
