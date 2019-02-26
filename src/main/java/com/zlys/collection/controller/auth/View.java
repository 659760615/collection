package com.zlys.collection.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:CZX
 * @create:2019-02-26 8:56
 * @desc: view
 **/
@Controller
@RequestMapping("common")
public class View {
     /**
       * @desc:考核中心 view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("check")
    public String check(){
        return "check";
    }
     /**
       * @desc: 系统管理_排班管理 view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("system_a")
    public String panbanG(){
        return "paibanG";
    }
     /**
       * @desc: 系统管理_预警中心 view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("unusual")
    public String unusual(){
        return "unusual";
    }

     /**
       * @desc: 监控中心 view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("examine")
    public String examine(){
        return "examine";
    }

     /**
       * @desc: 统计中心 view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("tongjiindex")
    public String tongjiindex(){
        return "tongjiindex";
    }

     /**
       * @desc: 系统管理_OA管理_员工管理 view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("system_b")
    public String yuangong(){
        return "yuangong";
    }

     /**
       * @desc: 系统管理_排班管理_排班表  view
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("system_aa")
    public String paibanB(){
        return "paibanB";
    }

    /**
     * @desc: 系统管理_OA管理_通知管理  view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_bb")
    public String addInform(){
        return "addInform";
    }

    /**
     * @desc: 系统管理_电子围栏_围栏管理  view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_c")
    public String quyu(){
        return "quyu";
    }
    /**
     * @desc: 系统管理_电子围栏_线路管理  view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_cc")
    public String xianlu(){
        return "xianlu";
    }
}
