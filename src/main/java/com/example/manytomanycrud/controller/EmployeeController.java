package com.example.manytomanycrud.controller;

import com.example.manytomanycrud.controller.Repository.EmployeeRepository;
import com.example.manytomanycrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/create-employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository  employeeRepository;

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        Employee employeeEntity = employeeRepository.findById(employee.getEmployeeId()).get();
        employeeEntity.setRank(355);
        employeeRepository.save(employeeEntity);
    }
}
