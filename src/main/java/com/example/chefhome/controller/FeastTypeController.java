package com.example.chefhome.controller;

import com.example.chefhome.main.HttpResult;
import com.example.chefhome.repository.FeastTypeRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeastTypeController {

    @Autowired
    FeastTypeRepository feastTypeRepository;

    private final static Logger logger = LoggerFactory.getLogger(FeastTypeController.class);

    // 查询
    @GetMapping(value = "/feastType")
    public HttpResult<FeastTypeController> feastTypeList() {
        logger.info("获取宴席类型数据");
        try{
            return HttpResultUtil.success(feastTypeRepository.findAll());
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取宴席类型数据失敗： " + e.toString());
        }
    }

    @GetMapping(value = "/feastType/{fid}")
    public HttpResult<FeastTypeController> feastTypeList(@PathVariable("fid") Integer fid) {
        logger.info("获取宴席id类型数据");
        try{
            return HttpResultUtil.success(feastTypeRepository.findOne(fid));
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取宴席id类型数据失敗： " + e.toString());
        }
    }

}
