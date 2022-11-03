package com.lagou.dao;

import com.lagou.domain.Menu;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface MenuMapper {
    public List<Menu> findAllMenu(Integer id);

    public List<Integer> findMenuByRoleId(Integer id);

    public void deleteByRoleId(Integer id);

    public void insert(Role_menu_relation roleMenuRelation);

    public void deleteRole(Integer id);

    public List<Menu> findAllMenu1();

    List<Menu> findMenuById(Integer id);

    void saveMenu(Menu menu);

    void UpdateMenu(Menu menu);
}
