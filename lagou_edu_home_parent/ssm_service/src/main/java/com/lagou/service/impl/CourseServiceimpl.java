package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.CourseVo1;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVo courseVo) {
        List<Course> courseByCondition = courseMapper.findCourseByCondition(courseVo);
        return courseByCondition;
    }

    @Override
    public void saveCourseAndTeacher(CourseVo1 courseVo1) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVo1);
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        courseMapper.saveCourse(course);
        //获取新插入的id
        int id = course.getId();
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVo1);
        teacher.setCourseId(id);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);
        courseMapper.saveTeacher(teacher);


    }

    @Override
    public CourseVo1 findCourseById(Integer id) {
        CourseVo1 courseById = courseMapper.findCourseById(id);
        return courseById;

    }

    @Override
    public void updateCourseAndTeacher(CourseVo1 courseVo1) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVo1);
        Date date = new Date();
        course.setUpdateTime(date);
        courseMapper.updateCourse(course);

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVo1);
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        courseMapper.updateTeacher(teacher);

    }

    @Override
    public void updateCourseStatus(Integer id, Integer Status) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(Status);
        course.setUpdateTime(new Date());
        courseMapper.updateCourseStatus(course);


    }


}
