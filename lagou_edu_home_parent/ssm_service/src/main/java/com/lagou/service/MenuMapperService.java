package com.lagou.service;

import com.lagou.domain.Menu;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface MenuMapperService {
    public List<Menu> findAllMenu();

    public List<Integer> findMenuByRoleId(Integer id);


    public void RoleContextMenu(Integer id, List<Integer> list);

    public void deleteRole(Integer id);

    public List<Menu> findAllMenu1();

    List<Menu> findMenuById(Integer id);

    void saveMenu(Menu menu);

    void UpdateMenu(Menu menu);

}
