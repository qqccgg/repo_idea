package com.lagou.domain;

import lombok.Data;

import java.util.Date;
@Data
public class coursevo2 {
    //主键
    private Integer id;

    //课程id
    private int courseId;

    //章节id
    private int sectionId;

    //课时主题
    private String theme;

    //课时时长
    private int duration;

    //是否免费
    private int isFree;

    //是否删除
    private int isDel;

    //排序
    private int orderNum;

    //状态
    private int status;

}
