package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourseVo;

import java.util.List;

public interface resourceMapper {
    List<ResourceCategory> findAllResourceCategory();

    List<Resource> findAllResource(ResourseVo resourseVo);

    void saveResource(Resource resourse);

    void UpdateResource(Resource resourse);

    void deleteResource(Integer id);
}
