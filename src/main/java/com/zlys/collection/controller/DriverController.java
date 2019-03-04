package com.zlys.collection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:CZX
 * @create:2019-03-04 10:22
 * @desc:
 **/
@Controller
@RequestMapping("driver")
public class DriverController {
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

}
