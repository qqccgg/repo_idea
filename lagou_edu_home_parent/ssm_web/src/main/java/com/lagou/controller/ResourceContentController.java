package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourseVo;
import com.lagou.domain.ResponseResult;

import com.lagou.service.ResourceContentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceContentController {
    @Autowired
    private ResourceContentService resourceContentService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllRole() {
        List<ResourceCategory> allResourceCategory = resourceContentService.findAllResourceCategory();
        return new ResponseResult(true, 200, "查询成功", allResourceCategory);
    }

    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourseVo resourseVo) {
        PageInfo<Resource> allResource = resourceContentService.findAllResource(resourseVo);
        return new ResponseResult(true, 200, "查询成功", allResource);
    }

    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody Resource resource) {
        if (resource.getId() == null) {
            resourceContentService.saveResource(resource);
            return new ResponseResult(true, 200, "保存成功", null);
        } else {
            resourceContentService.UpdateResource(resource);
            return new ResponseResult(true, 200, "修改成功", null);
        }
    }
    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(Integer id) {
        resourceContentService.deleteResource(id);
        return new ResponseResult(true, 200, "删除成功", null);
    }

}
