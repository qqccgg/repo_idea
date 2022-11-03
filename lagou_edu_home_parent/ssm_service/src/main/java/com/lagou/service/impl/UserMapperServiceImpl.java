package com.lagou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserMapperService;

import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserMapperServiceImpl implements UserMapperService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAllUserByPage(UserVo userVo) {
        PageHelper.startPage(userVo.getCurrentPage(), userVo.getPageSize());
        List<User> allUserByPage = userMapper.findAllUserByPage(userVo);
        PageInfo<User> userPageInfo = new PageInfo<>(allUserByPage);
        return userPageInfo;
    }

    @Override
    public void updateUserStatus(User user) {
        user.setUpdate_time(new Date());
        userMapper.updateUserStatus(user);

    }

    @Override
    public User login(String name, String password) throws Exception {
        User login = userMapper.login(name);
        String lagou = Md5.md5("lagou", password);
        if (null != login && Md5.verify(password, "lagou", login.getPassword())) {
            return login;
        } else return null;

    }

    @Override
    public List<Role> findUserRoleById(Integer id) {
        List<Integer> userRoleIdById = userMapper.findUserRoleIdById(id);
        List<Role> roles = new ArrayList<>();

        for (int a : userRoleIdById
        ) {

            roles.add(userMapper.findUserRoleById(a));
        }
        return roles;
    }

    @Override
    public ResponseResult getUserPermissions(Integer id) {
        List<Integer> list = userMapper.findUserRoleIdById(id);
        List<Menu> fatherMenuById = userMapper.findFatherMenuById(list);
        for (Menu menu : fatherMenuById
        ) {

            menu.setSubMenuList(userMapper.findSonMenuById(menu.getId()));

        }
        List<Resource> resourceByrId = userMapper.findResourceByrId(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("menuList",fatherMenuById);
        map.put("resourceList",resourceByrId);
        return  new ResponseResult(true, 1, "success", map);
    }
}
