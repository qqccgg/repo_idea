package com.lagou.service.impl;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.domain.Role_menu_relation;
import com.lagou.service.MenuMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuMapperServiceImpl implements MenuMapperService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAllMenu() {
        List<Menu> menuInfoById = menuMapper.findAllMenu(-1);
        return menuInfoById;
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer id) {
        List<Integer> menuByRoleId = menuMapper.findMenuByRoleId(id);
        return menuByRoleId;
    }


    @Override
    public void RoleContextMenu(Integer id, List<Integer> list) {
        menuMapper.deleteByRoleId(id);
        for (Integer a : list
        ) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setCreatedBy("abc");
            role_menu_relation.setUpdatedby("abc");
            role_menu_relation.setCreatedTime(new Date());
            role_menu_relation.setUpdatedTime(new Date());
            role_menu_relation.setRoleId(id);
            role_menu_relation.setMenuId(a);
            menuMapper.insert(role_menu_relation);

        }
    }

    @Override
    public void deleteRole(Integer id) {
        menuMapper.deleteByRoleId(id);
        menuMapper.deleteRole(id);
    }

    @Override
    public List<Menu> findAllMenu1() {
        List<Menu> allMenu = menuMapper.findAllMenu1();
        return allMenu;

    }

    @Override
    public List<Menu> findMenuById(Integer id) {
        List<Menu> menuById = menuMapper.findMenuById(id);
        return menuById;
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.saveMenu(menu);
    }

    @Override
    public void UpdateMenu(Menu menu) {
        menuMapper.UpdateMenu(menu);
    }


}
