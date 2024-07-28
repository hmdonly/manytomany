package com.example.manytomanycrud.dto;

public class SchoolStudentDto {

    private Long schoolId;

    private Long [] studentIds;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long[] getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(Long[] studentIds) {
        this.studentIds = studentIds;
    }
}
