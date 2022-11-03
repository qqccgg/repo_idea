package com.lagou.dao;


import com.lagou.domain.CourseSection;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface promotionMapper {
    public List<PromotionSpace> findAllPromotionSpace();

    public void savePromotionSpace(PromotionSpace promotionSpace);

    public void UpdatePromotionSpace(PromotionSpace promotionSpace);

    public PromotionSpace findPromotionSpaceById(Integer id);

    public List<PromotionAd> findAllPromotionAdByPage();

    public void savePromotionAd(PromotionAd promotionAd);

    public void UpdatePromotionAd(PromotionAd promotionAd);

    public PromotionAd findPromotionAdById(Integer id);

    public void updatePromotionAdStatus(PromotionAd promotionAd);

}
