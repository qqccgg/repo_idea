package com.lagou.domain;

public class CourseVo {
    private String courseName;
    private Integer status;




    public CourseVo(String courseName, Integer status) {
        this.courseName = courseName;
        this.status = status;

    }

    public String getCourseName() {
        return courseName;
    }

    public CourseVo() {
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
