package com.example.manytomanycrud.controller;

import com.example.manytomanycrud.controller.Repository.SchoolRepository;
import com.example.manytomanycrud.controller.Repository.StudentRepository;
import com.example.manytomanycrud.dto.SchoolStudentDto;
import com.example.manytomanycrud.entity.School;
import com.example.manytomanycrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }


    @PostMapping("/addSchool")
    public void addSchool(@RequestBody School school) {

        schoolRepository.save(school);
    }

    @PostMapping("/mapstudentschool")
    public void mapStudentSchool(@RequestBody SchoolStudentDto schoolStudentDto) {
        Optional<School> school = schoolRepository.findById(schoolStudentDto.getSchoolId());
        Set<Student> schoolSet = new HashSet<>();

        Arrays.stream(schoolStudentDto.getStudentIds()).forEach(studentId -> {

            Optional<Student> student = studentRepository.findById(studentId);
            schoolSet.add(student.get());
        });
        school.get().getStudents().addAll(schoolSet);
        schoolRepository.save(school.get());

    }

    @GetMapping("/students")
    public Set<School> getStudentMapTest() {

       Student student =  studentRepository.findAll().get(2);
        return student.getSchools();
    }

    @GetMapping("/schools")
    public Set<Student> getSchool() {

        return schoolRepository.findAll().get(5).getStudents();
    }
}

