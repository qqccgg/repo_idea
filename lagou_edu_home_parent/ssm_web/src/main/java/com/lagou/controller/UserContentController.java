package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.*;
import com.lagou.service.MenuMapperService;
import com.lagou.service.UserMapperService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserContentController {
    @Autowired
    private UserMapperService userMapperService;
    @Autowired
    private MenuMapperService menuMapperService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo) {
        PageInfo<User> allUserByPage = userMapperService.findAllUserByPage(userVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "查询成功", allUserByPage);
        return responseResult;

    }

    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(User user) {
        userMapperService.updateUserStatus(user);
        ResponseResult responseResult = new ResponseResult(true, 200, "修改章节状态成功", null);
        return responseResult;

    }

    @RequestMapping("/login")
    public ResponseResult login(String phone, String password, HttpServletRequest request) throws Exception {
        User login = userMapperService.login(phone, password);
        if (null != login) {
            String s = UUID.randomUUID().toString();
            HttpSession session = request.getSession();
            session.setAttribute("access_token", s);
            session.setAttribute("user_id", login.getId());
            HashMap<String, Object> map = new HashMap<>();
            map.put("access_token", s);
            map.put("user_id", login.getId());
            return new ResponseResult(true, 1, "success", map);
        } else {
            return new ResponseResult(false, 2, "false", null);
        }


    }

    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(Integer id) {
        List<Role> userRoleById = userMapperService.findUserRoleById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "查询成功", userRoleById);
        return responseResult;

    }

    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        if (authorization.equals(access_token)){
            return userMapperService.getUserPermissions((Integer) session.getAttribute("user_id"));
        }else {

            return  new ResponseResult(false, 400, "shibai", null);
        }



    }


}
