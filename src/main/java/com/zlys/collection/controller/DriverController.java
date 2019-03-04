package com.zlys.collection.controller;

import com.zlys.collection.entity.DriverEntity;
import com.zlys.collection.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:CZX
 * @create:2019-03-04 10:22
 * @desc:
 **/
@Controller
@RequestMapping("driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    /**
     * @desc: 系统管理_角色管理 view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_d")
    public String quanxian(){
        /*all*/

        /*区域*/
        return "quanxian";
    }

    @PostMapping("allDriver")
    @ResponseBody
    public Object  allDriver(){
        return driverService.queryAll();
    }
}
