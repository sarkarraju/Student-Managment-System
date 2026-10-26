package com.students.student.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.students.student.entity.Student;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // add student

    public int add(Student student) {

        String query = "insert into details (name,email,ph_no,age,gender,course) values(?,?,?,?,?,?)";

        return jdbcTemplate.update(
                query,
                student.getName(),
                student.getEmail(),
                student.getPh_no(),
                student.getAge(),
                student.getGender(),
                student.getCourse());

    }

    public List<Student> getAll() {
        String query = "select * from details";

        return jdbcTemplate.query(query, (rs, rowNum) -> {

            Student student = new Student();

            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setPh_no(rs.getString("ph_no"));
            student.setAge(rs.getInt("age"));
            student.setGender(rs.getString("gender"));
            student.setCourse(rs.getString("course"));

            return student;
        });
    }

// Get student by ID
public Student getById(int id) {

    String query = "SELECT * FROM details WHERE id=?";

    System.out.println("Searching student ID: " + id);

    return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {

        Student student = new Student();

        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setPh_no(rs.getString("ph_no"));
        student.setAge(rs.getInt("age"));
        student.setGender(rs.getString("gender"));
        student.setCourse(rs.getString("course"));

        return student;

    }, id);

}


// Update student
public int update(Student student) {

    String query = "UPDATE details SET name=?, email=?, ph_no=?, age=?, gender=?, course=? WHERE id=?";

    return jdbcTemplate.update(
            query,
            student.getName(),
            student.getEmail(),
            student.getPh_no(),
            student.getAge(),
            student.getGender(),
            student.getCourse(),
            student.getId()
    );
}


// Delete student
public int delete(int id) {

    String query = "DELETE FROM details WHERE id=?";

    return jdbcTemplate.update(query, id);
}



    
}
