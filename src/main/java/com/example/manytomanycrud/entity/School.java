package com.example.manytomanycrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id", unique = true, nullable = false)
    private int schoolId;
    @Column(name = "schoolname")
    private String  schoolName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })

    @JoinTable(name = "student_school",
            joinColumns = { @JoinColumn(name = "school_id",referencedColumnName = "school_id")},
            inverseJoinColumns = { @JoinColumn(name = "student_id",referencedColumnName = "student_id") })
    private Set<Student> students;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Column(name = "place")
    private String place;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
