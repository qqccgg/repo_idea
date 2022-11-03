package com.lagou.controller;


import com.lagou.domain.test;
import com.lagou.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //@Controller + @ResponseBody
@RequestMapping("/test")
public class TestController {

    @Autowired
    private testService testService;

    @RequestMapping("/findAllTest")
    public List<test> findAllTest(){

        List<test> allTest = testService.findall();
        return allTest;

    }


}
