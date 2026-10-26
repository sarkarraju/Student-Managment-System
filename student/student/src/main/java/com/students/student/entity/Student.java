package com.students.student.entity;

public class Student {
    private int id;
    private String name;
    private String email;
    private String ph_no;
    private int age;
    private String gender;
    private String course;

    public Student(int id, String name, String email, String ph_no, int age, String gender, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ph_no = ph_no;
        this.age = age;
        this.gender = gender;
        this.course = course;

    }

    public Student() {
    }

    public Student(String name, String email, String ph_no, int age, String gender, String course) {
        this.name = name;
        this.email = email;
        this.ph_no = ph_no;
        this.age = age;
        this.gender = gender;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
