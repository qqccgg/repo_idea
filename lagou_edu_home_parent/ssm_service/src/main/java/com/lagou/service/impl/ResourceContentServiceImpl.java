package com.lagou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.courseContentMaaper;
import com.lagou.dao.resourceMapper;
import com.lagou.domain.*;
import com.lagou.service.ResourceContentService;
import com.lagou.service.courseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceContentServiceImpl implements ResourceContentService {
    @Autowired
    private com.lagou.dao.resourceMapper resourceMapper;


    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        List<ResourceCategory> allResourceCategory = resourceMapper.findAllResourceCategory();
        return allResourceCategory;
    }

    @Override
    public PageInfo<Resource> findAllResource(ResourseVo resourseVo) {
        PageHelper.startPage(resourseVo.getCurrentPage(), resourseVo.getPageSize());
        List<Resource> allResource = resourceMapper.findAllResource(resourseVo);
        PageInfo<Resource> resourcePageInfo = new PageInfo<>(allResource);
        return resourcePageInfo;
    }

    @Override
    public void saveResource(Resource resource) {
        resource.setCreatedTime(new Date());
        resource.setUpdatedTime(new Date());
        resource.setCreatedBy("abc");
        resource.setUpdatedBy("abc");
        resourceMapper.saveResource(resource);
    }

    @Override
    public void UpdateResource(Resource resource) {

        resource.setUpdatedTime(new Date());

        resource.setUpdatedBy("abc");

        resourceMapper.UpdateResource(resource);
    }

    @Override
    public void deleteResource(Integer id) {
        resourceMapper.deleteResource(id);
    }


}
