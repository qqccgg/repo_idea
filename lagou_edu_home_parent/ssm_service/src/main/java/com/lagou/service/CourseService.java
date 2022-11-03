package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.CourseVo1;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {
    public List<Course> findCourseByCondition(CourseVo courseVo);

    public void saveCourseAndTeacher(CourseVo1 courseVo1) throws InvocationTargetException, IllegalAccessException;

    public CourseVo1 findCourseById(Integer id);

    public void updateCourseAndTeacher(CourseVo1 courseVo1) throws InvocationTargetException, IllegalAccessException;

    public void updateCourseStatus(Integer id, Integer Status);


}
