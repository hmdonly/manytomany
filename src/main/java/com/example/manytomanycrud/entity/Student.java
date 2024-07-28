package com.example.manytomanycrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true, nullable = false)
    private int studentId;


    @Column(name = "student_name")
    private String studentName;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "students")
    private Set<School> schools;

    @Column(name = "age")
    private int age;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }
}
