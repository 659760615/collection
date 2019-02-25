package com.zlys.collection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:CZX
 * @create:2019-02-25 13:29
 * @desc:
 **/
@Controller
@RequestMapping("test")
public class Test {

    @RequestMapping("test")
    public String run(){
        System.out.println("测试");
        return "test";
    }
}
