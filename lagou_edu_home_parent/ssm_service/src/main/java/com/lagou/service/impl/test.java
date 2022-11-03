package com.lagou.service.impl;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class test {
    @Autowired
    private com.lagou.dao.testMapper testMapper;
    @Autowired
    private CourseService courseService;

    @Test
    public void test1() {
        List<com.lagou.domain.test> findall = testMapper.findall();
        System.out.println(findall);
    }

    @Test
    public void test2() {

        List<Course> courseByCondition = courseService.findCourseByCondition(new CourseVo("大数据", 1));
        System.out.println(courseByCondition);
    }
}