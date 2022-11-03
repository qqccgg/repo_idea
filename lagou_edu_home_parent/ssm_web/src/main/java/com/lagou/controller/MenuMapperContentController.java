package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.RoleMenuVo;
import com.lagou.service.MenuMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuMapperContentController {
    @Autowired
    private MenuMapperService menuMapperService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {
        List<Menu> menuInfo = menuMapperService.findAllMenu();
        HashMap<String, Object> m = new HashMap<>();
        m.put("parentMenuList", menuInfo);
        return new ResponseResult(true, 200, "查询成功", m);
    }

    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer id) {
        List<Integer> menuInfo = menuMapperService.findMenuByRoleId(id);

        return new ResponseResult(true, 200, "查询成功", menuInfo);
    }

    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo) {
        menuMapperService.RoleContextMenu(roleMenuVo.getRoleId(), roleMenuVo.getMenuIdList());

        return new ResponseResult(true, 200, "查询成功", null);
    }

    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id) {
        menuMapperService.deleteRole(id);

        return new ResponseResult(true, 200, "删除成功", null);
    }

    @RequestMapping("/findAllMenu1")
    public ResponseResult findAllMenu1() {
        List<Menu> menuInfo = menuMapperService.findAllMenu1();
        return new ResponseResult(true, 200, "查询成功", menuInfo);
    }

    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id) {
        if (-1 == id) {
            List<Menu> menuInfo = menuMapperService.findAllMenu();
            HashMap<String, Object> m = new HashMap<>();
            m.put("menuInfo", null);
            m.put("parentMenuList", menuInfo);
            return new ResponseResult(true, 200, "查询成功", m);

        } else {

            List<Menu> menuById = menuMapperService.findMenuById(id);
            List<Menu> menuInfo = menuMapperService.findAllMenu();
            HashMap<String, Object> m = new HashMap<>();
            m.put("menuInfo", menuById);
            m.put("parentMenuList", menuInfo);
            return new ResponseResult(true, 200, "查询成功", m);

        }
    }

    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu) {
        if (menu.getId() != null) {
            menuMapperService.UpdateMenu(menu);
            return new ResponseResult(true, 200, "修改", null);
        } else {
            menuMapperService.saveMenu(menu);

            return new ResponseResult(true, 200, "新增", null);
        }
    }
}


