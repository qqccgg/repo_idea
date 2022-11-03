package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface UserMapper {
    public List<User> findAllUserByPage(UserVo userVo);

    public void updateUserStatus(User user);

    public User login(String name);

    public Role findUserRoleById(Integer id);

    public List<Integer> findUserRoleIdById(Integer id);

    public List<Menu> findFatherMenuById(List<Integer> ids);

    public List<Menu> findSonMenuById(Integer pid);

    public List<Resource> findResourceByrId(List<Integer> ids);


}
