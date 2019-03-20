package com.zlys.collection.controller.auth;

import com.zlys.collection.entity.DepartmentEntity;
import com.zlys.collection.service.DepartmentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:CZX
 * @create:2019-02-25 13:31
 * @desc:
 **/
@Controller
@RequestMapping("zlys")
public class Login {
    private static Logger logger = LoggerFactory.getLogger(Login.class);

    @Autowired
    private DepartmentService departmentService;

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
    public String common(Model model){
        /*所有的部门*/
        List<String> list=departmentService.queryAllName();
        model.addAttribute("departments",list);
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
