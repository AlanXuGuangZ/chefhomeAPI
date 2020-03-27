package com.example.chefhome.controller;


import com.example.chefhome.main.Chef;
import com.example.chefhome.main.HttpResult;
import com.example.chefhome.repository.ChefRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 厨师接口
 */
@RestController
public class ChefController {
    @Autowired
    ChefRepository chefRepository;

    private final static Logger logger = LoggerFactory.getLogger(ChefController.class);

    /**
     * 查询所有厨师接口
     */
    @GetMapping(value = "/chef")
    public HttpResult<Chef> chefList() {

        logger.info("获取厨师数据");

        return HttpResultUtil.success(chefRepository.findAll());
    }

    /**
     * 更新pick次数
     */
}
