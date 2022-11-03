package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.promotionMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.promotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class promotionServiceImpl implements promotionService {
    @Autowired
    private promotionMapper promotionMapper;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        List<PromotionSpace> allPromotionSpace = promotionMapper.findAllPromotionSpace();
        return allPromotionSpace;
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        Date date = new Date();
        promotionSpace.setUpdateTime(date);
        promotionSpace.setCreateTime(date);
        promotionMapper.savePromotionSpace(promotionSpace);


    }

    @Override
    public void UpdatePromotionSpace(PromotionSpace promotionSpace) {
        Date date = new Date();
        promotionSpace.setUpdateTime(date);
        promotionMapper.UpdatePromotionSpace(promotionSpace);


    }

    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {
        PromotionSpace promotionSpaceById = promotionMapper.findPromotionSpaceById(id);
        return promotionSpaceById;
    }

    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {
        PageHelper.startPage(promotionAdVO.getCurrentPage(), promotionAdVO.getPageSize());

        List<PromotionAd> allPromotionAdByPage = promotionMapper.findAllPromotionAdByPage();
        PageInfo<PromotionAd> promotionAdPageInfo = new PageInfo<>(allPromotionAdByPage);
        return promotionAdPageInfo;
    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);
        promotionMapper.savePromotionAd(promotionAd);
    }

    @Override
    public void UpdatePromotionAd(PromotionAd promotionAd) {
        Date date = new Date();
        promotionAd.setUpdateTime(date);
        promotionMapper.UpdatePromotionAd(promotionAd);

    }

    @Override
    public PromotionAd findPromotionAdById(Integer id) {
        PromotionAd promotionAdById = promotionMapper.findPromotionAdById(id);
        return promotionAdById;
    }

    @Override
    public void updatePromotionAdStatus(Integer id, Integer status) {
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setUpdateTime(new Date());
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionMapper.updatePromotionAdStatus(promotionAd);
    }

}
