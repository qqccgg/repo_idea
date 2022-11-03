package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.*;

import java.util.List;

public interface UserMapperService {
    public PageInfo<User> findAllUserByPage(UserVo userVo);

    public void updateUserStatus(User user);

    public User login(String name, String password) throws Exception;

    public List<Role> findUserRoleById(Integer id);

    public ResponseResult getUserPermissions(Integer id);



}
