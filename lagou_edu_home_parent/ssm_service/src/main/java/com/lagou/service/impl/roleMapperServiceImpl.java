package com.lagou.service.impl;

import com.lagou.dao.roleMapper;
import com.lagou.domain.Role;
import com.lagou.service.roleMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class roleMapperServiceImpl implements roleMapperService {
    @Autowired
    private com.lagou.dao.roleMapper roleMapper;

    @Override
    public List<Role> findAllRole(String name) {
        List<Role> allRole = roleMapper.findAllRole(name);
        return allRole;
    }

    @Override
    public void UpdateRole(Role role) {
        role.setUpdatedTime(new Date());
        roleMapper.UpdateRole(role);
    }

    @Override
    public void saveRole(Role role) {
        role.setUpdatedTime(new Date());
        role.setCreatedTime(new Date());
        roleMapper.saveRole(role);
    }
}
