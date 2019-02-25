package com.zlys.collection.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author:CZX
 * @create:2019-02-25 13:31
 * @desc:
 **/
@Controller
@RequestMapping("/zlys")
public class Login {
    private static Logger logger = LoggerFactory.getLogger(Login.class);
     /**
       * @desc: login view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("/login")
    public String login(){
        return "Login";
    }

     /**
       * @desc: 首页 view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("/commond")
    public String common(){
        return "commond";
    }


}
