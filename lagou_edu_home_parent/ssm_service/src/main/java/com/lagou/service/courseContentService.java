package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface courseContentService {
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id);

    public Course findByCourseId(int courseId);

    public void saveCourseSection(CourseSection courseSection);

    public void updateCourseSection(CourseSection courseSection);

    public void updateSectionStatus(int id, int status);


}
