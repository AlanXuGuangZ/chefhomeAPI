package com.example.chefhome.controller;

import com.example.chefhome.main.HttpResult;
import com.example.chefhome.main.Menu;
import com.example.chefhome.repository.MenuRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    private final static Logger logger = LoggerFactory.getLogger(MenuController.class);

    /**
     * 查询菜品
     */
    @GetMapping(value = "/menu")
    public HttpResult<Menu> menuList() {

        return HttpResultUtil.success(menuRepository.findAll());
    }

    //更新
    @PostMapping("/menu/update/{id}")
    public HttpResult<Menu> updateChef(@PathVariable("id") Integer id, Menu menuIn){
        logger.info("更新菜品数据");
        try {
            Menu menuOut = menuRepository.getOne(id);
            BeanUtils.copyProperties(menuIn, menuOut, OrderController.getNullPropertyNames(menuIn));
            return HttpResultUtil.success(menuRepository.save(menuOut));
        } catch (Exception e){
            return HttpResultUtil.error(400,"更新菜品数据失败: " + e.toString());
        }
    }

}
