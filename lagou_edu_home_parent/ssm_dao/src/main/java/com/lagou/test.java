package com.lagou;

/*import com.lagou.dao.testMapper;*/
import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring.xml")
public class test {
    @Autowired
    private com.lagou.dao.testMapper testMapper;
    @Autowired
    private com.lagou.dao.CourseMapper courseMapper;

    @Test
    public void test1() {
        List<com.lagou.domain.test> findall = testMapper.findall();
        System.out.println(findall);

    }

    @Test
    public void test2() {

        List<Course> courseByCondition = courseMapper.findCourseByCondition(new CourseVo("大数据", 0));
        System.out.println(courseByCondition);
    }

}
