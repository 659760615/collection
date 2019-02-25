package com.zlys.collection.controller.auth;

import com.zlys.collection.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author:CZX
 * @create:2019-02-25 19:05
 * @desc:
 **/
@Controller
@RequestMapping("/auth")
public class Auth {

    /**
     * @desc: 登录
     * @param:
     * @return:
     * @auther: czx
     */
    @PostMapping("/loginUser")
    @ResponseBody
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            model.addAttribute("this",user) ;
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
