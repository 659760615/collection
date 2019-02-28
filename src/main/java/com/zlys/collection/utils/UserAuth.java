package com.zlys.collection.utils;

import javax.servlet.http.HttpSession;

/**
 * @author:CZX
 * @create:2019-02-28 9:25
 * @desc:
 **/
public class UserAuth {
     /**
       * @desc: 判断是否是admin或者中科绵投登录
       * @param:
       * @return:  null or 登录单位的编号
       * @auther: czx
       */
    public String user(HttpSession session){
        String username= (String) session.getAttribute("user");
        if("admin".equals(username) || "zkmt".equals(username)){
            return null;
        }
        return (String) session.getAttribute("user");
    }
}
