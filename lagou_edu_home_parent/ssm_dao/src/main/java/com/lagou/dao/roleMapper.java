package com.lagou.dao;

import com.lagou.domain.Role;

import java.util.List;

public interface roleMapper {
    public List<Role> findAllRole(String name);

    public void UpdateRole(Role role);

    public void saveRole(Role role);
}
