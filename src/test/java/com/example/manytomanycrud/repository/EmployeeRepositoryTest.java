package com.example.manytomanycrud.repository;

import com.example.manytomanycrud.controller.Repository.EmployeeRepository;
import com.example.manytomanycrud.entity.Employee;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class EmployeeRepositoryTest {
    @BeforeEach
    public void setupTestData(){
        // Given : Setup object or precondition
        employee = new Employee();
        employee.setEmployeeId(1l);
    }
    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject()
    {
        // Given : Setup object or precondition
        employeeRepository.save(employee);

        Employee getEmployee = employeeRepository.findById(employee.getEmployeeId()).get();
        assertThat(getEmployee.getEmployeeId()).isEqualTo(1l);

    }

    @Sql(value = "insert.xml")
    @Test
    public void verifyEmployeeObject()
    {
        // Given : Setup object or precondition
        employeeRepository.save(employee);

        Employee getEmployee = employeeRepository.findById(employee.getEmployeeId()).get();
        assertThat(getEmployee.getEmployeeId()).isEqualTo(1l);

    }



}
