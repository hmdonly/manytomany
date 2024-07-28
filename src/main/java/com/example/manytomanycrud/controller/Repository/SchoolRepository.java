package com.example.manytomanycrud.controller.Repository;

import com.example.manytomanycrud.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {



}
