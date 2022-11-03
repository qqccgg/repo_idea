package com.lagou.service.impl;

import com.lagou.dao.testMapper;
import com.lagou.domain.test;
import com.lagou.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



/*
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)//事务管理器
*/
@Service
public class testServiceimpl implements testService {
    @Autowired
    private testMapper testMapper;

    @Override
    public List<test> findall() {
        List<test> findall = testMapper.findall();
        return findall;
    }
}
