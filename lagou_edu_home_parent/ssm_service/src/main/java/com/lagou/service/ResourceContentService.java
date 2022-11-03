package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourseVo;

import java.util.List;

public interface ResourceContentService {
    List<ResourceCategory> findAllResourceCategory();

    PageInfo<Resource> findAllResource(ResourseVo resourseVo);

    void saveResource(Resource resource);

    void UpdateResource(Resource resource);

    void deleteResource(Integer id);
}
