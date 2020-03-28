//package com.example.chefhome.controller;
//
//import com.example.chefhome.main.HttpResult;
//import com.example.chefhome.main.Menu;
//import com.example.chefhome.repository.MenuRepository;
//import com.example.chefhome.units.HttpResultUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 菜品接口
// * Created by v-xuyongbiao@meizu.com on 2020/3/27 上午9:43.
// */
//
//@RestController
//public class MenuController {
//
//    @Autowired
//    MenuRepository menuRepository;
//
//    private final static Logger logger = LoggerFactory.getLogger(MenuController.class);
//
//    /**
//     * 查询菜品
//     */
//    @GetMapping(value = "/menu")
//    public HttpResult<Menu> menuList() {
//
//        return HttpResultUtil.success(menuRepository.findAll());
//    }
//
//}
