package com.example.manytomanycrud.controller.Repository;

import com.example.manytomanycrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Long> {


}

