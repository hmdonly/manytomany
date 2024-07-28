package com.example.manytomanycrud.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.mapstruct.Builder;

@Entity
@Table(name = "employee")
//@DynamicUpdate
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", unique = true, nullable = false)
    private Long employeeId;

    private String employeeName;

    private int age;

    private int rank;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
