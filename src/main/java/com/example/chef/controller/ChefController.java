package com.example.chef.controller;


import com.example.chef.main.Chef;
import com.example.chef.main.HttpResult;
import com.example.chef.repository.ChefRepository;
import com.example.chef.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @GetMapping(value ="/chef")
    public HttpResult<Chef> chefList() {
        return HttpResultUtil.success(chefRepository.findAll());
    }

    /**
     * 更新pick次数
     */
}
