package com.zlys.collection.controller.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
@RequestMapping("zlys")
public class Login {
    private static Logger logger = LoggerFactory.getLogger(Login.class);
     /**
       * @desc: login view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("login")
    public String login(){
        return "login";
    }

     /**
       * @desc: index view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("commond")
    public String common(){
        return "commond";
    }
     /**
       * @desc: loginOut
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "redirect:login";
    }
}
