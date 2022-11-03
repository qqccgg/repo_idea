package com.lagou.controller;

import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.service.roleMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleContentController {
    @Autowired
    private com.lagou.service.roleMapperService roleMapperService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role) {
        String name = role.getName();
        List<Role> allRole = roleMapperService.findAllRole(name);
        return new ResponseResult(true, 200, "查询成功", allRole);
    }

    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role) {
        if (role.getId() == null) {
            roleMapperService.saveRole(role);
            return new ResponseResult(true, 200, "保存", null);
        }else {
            roleMapperService.UpdateRole(role);
            return new ResponseResult(true, 200, "修改", null);
        }
    }

}
