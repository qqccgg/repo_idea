package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.*;
import com.lagou.service.promotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/PromotionSpace")
public class promotionController {
    @Autowired
    private promotionService promotionService;

    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace() {
        List<PromotionSpace> allPromotionSpace = promotionService.findAllPromotionSpace();
       /* Map<Object, Object> map = new HashMap<>();
        map.put("content", allPromotionSpace);*/
        return new ResponseResult(true, 200, "查询广告位置信息成功", allPromotionSpace);
    }

    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace) {
        if (null == promotionSpace.getId()) {
            promotionService.savePromotionSpace(promotionSpace);

            return new ResponseResult(true, 200, "保存成功", null);
        } else {
            promotionService.UpdatePromotionSpace(promotionSpace);
            return new ResponseResult(true, 200, "修改成功", null);
        }
    }

    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(Integer id) {
        PromotionSpace promotionSpaceById = promotionService.findPromotionSpaceById(id);
        return new ResponseResult(true, 200, "查询成功", promotionSpaceById);
    }

    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {
        PageInfo<PromotionAd> allPromotionAdByPage = promotionService.findAllPromotionAdByPage(promotionAdVO);
        return new ResponseResult(true, 200, "查询成功", allPromotionAdByPage);
    }

    @RequestMapping("/PromotionAdUpload")
    public ResponseResult PromotionAdUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //1.判断接收到的上传文件是否为空
        if (file.isEmpty()) {
            throw new RuntimeException();
        }

        //2.获取项目部署路径

        // D:\apache-tomcat-8.5.56\webapps\ssm-web\
        String realPath = request.getServletContext().getRealPath("/");
        // D:\apache-tomcat-8.5.56\webapps
        String substring = realPath.substring(0, realPath.indexOf("ssm_web"));


        //3.获取原文件名
        //lagou.jpg
        String originalFilename = file.getOriginalFilename();

        //4.生成新文件名
        //12421321.jpg
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //5.文件上传

        String uploadPath = substring + "upload\\";
        File filePath = new File(uploadPath, newFileName);

        // 如果目录不存在就创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录：" + filePath);
        }

        // 图片就进行了真正的上传
        file.transferTo(filePath);

        // 6. 将文件名和文件路径返回，进行响应
        Map<String, String> map = new HashMap<>();
        map.put("fileName", newFileName);

        map.put("filePath", "http://localhost:8080/upload/" + newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);

        return responseResult;

    }

    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd) {
        if (null == promotionAd.getId()) {
            promotionService.savePromotionAd(promotionAd);
            return new ResponseResult(true, 200, "保存成功", null);
        } else {
            promotionService.UpdatePromotionAd(promotionAd);
            return new ResponseResult(true, 200, "修改成功", null);
        }
    }

    @RequestMapping("/PromotionAdById")
    public ResponseResult PromotionAdById(Integer id) {
        PromotionAd promotionAdById = promotionService.findPromotionAdById(id);

        return new ResponseResult(true, 200, "响应成功", promotionAdById);

    }

    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(Integer id, Integer status) {
        promotionService.updatePromotionAdStatus(id, status);
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", status);


        return new ResponseResult(true, 200, "响应成功", map);

    }


}

