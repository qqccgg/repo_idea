package com.lagou.service.impl;

import com.lagou.dao.courseContentMaaper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.service.courseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class courseContentServiceImpl implements courseContentService {
    @Autowired
    private courseContentMaaper courseContentMaaper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id) {
        List<CourseSection> list = courseContentMaaper.findSectionAndLesson(id);
        return list;
    }

    @Override
    public Course findByCourseId(int courseId) {
        Course byCourseId = courseContentMaaper.findByCourseId(courseId);
        return byCourseId;
    }

    @Override
    public void saveCourseSection(CourseSection courseSection) {

        courseSection.setCreateTime(new Date());
        courseSection.setUpdateTime(new Date());
        ;
        courseContentMaaper.saveCourseSection(courseSection);
    }

    @Override
    public void updateCourseSection(CourseSection courseSection) {
        courseSection.setUpdateTime(new Date());
        courseContentMaaper.updateCourseSection(courseSection);
    }

    @Override
    public void updateSectionStatus(int id, int status) {
        CourseSection courseSection = new CourseSection();
            courseSection.setId(id);
            courseSection.setStatus(status);
            courseSection.setUpdateTime(new Date());
        courseContentMaaper.updateSectionStatus(courseSection);
    }
}
