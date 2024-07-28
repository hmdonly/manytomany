package com.example.manytomanycrud.controller.Repository;

import com.example.manytomanycrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
