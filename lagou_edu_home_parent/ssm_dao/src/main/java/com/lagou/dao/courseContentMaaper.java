package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface courseContentMaaper {

    public List<CourseSection> findSectionAndLesson(int courseId);

    public Course findByCourseId(int courseId);

    public void saveCourseSection(CourseSection courseSection);

    public void updateCourseSection(CourseSection courseSection);

    public void updateSectionStatus(CourseSection courseSection);




}
