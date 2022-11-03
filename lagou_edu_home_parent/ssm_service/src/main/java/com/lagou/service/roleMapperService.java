package com.lagou.service;

import com.lagou.dao.roleMapper;
import com.lagou.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface roleMapperService {
    public List<Role> findAllRole(String name);

    public void UpdateRole(Role role);

    public void saveRole(Role role);
}
