package com.example.chefhome.controller;

import com.example.chefhome.main.HttpResult;
import com.example.chefhome.repository.FeastRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeastController {

    @Autowired
    FeastRepository feastRepository;

    private final static Logger logger = LoggerFactory.getLogger(FeastController.class);

    // 查询
    @GetMapping(value = "/feast")
    public HttpResult<FeastController> feastList() {
        logger.info("获取宴席数据");
        try{
            return HttpResultUtil.success(feastRepository.findAll());
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取宴席数据失敗： " + e.toString());
        }
    }
}
