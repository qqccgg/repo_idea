package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface promotionService {
    public List<PromotionSpace> findAllPromotionSpace();

    public void savePromotionSpace(PromotionSpace promotionSpace);

    public void UpdatePromotionSpace(PromotionSpace promotionSpace);

    public PromotionSpace findPromotionSpaceById(Integer id);

    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    public void savePromotionAd(PromotionAd promotionAd);

    public void UpdatePromotionAd(PromotionAd promotionAd);

    public PromotionAd findPromotionAdById(Integer id);

    public void updatePromotionAdStatus(Integer id ,Integer status );
}
