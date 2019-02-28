package com.zlys.collection.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlys.collection.entity.DepartmentArea;
import com.zlys.collection.entity.DepartmentEntity;
import com.zlys.collection.entity.User;
import com.zlys.collection.service.DepartmentAreaService;
import com.zlys.collection.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:CZX
 * @create:2019-02-26 15:24
 * @desc:
 **/
@Controller
@RequestMapping("department")
public class DepartmentController {

    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentAreaService departmentAreaService;


    /**
     * @desc: 系统管理_部门管理 view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_e")
    public String bumen(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, Model model, HttpSession session){
        /*返回值为当前登录的部门名称      null为(admin or zkmt)*/
        String departmentName = user(session);
        /*获取区域信息*/
        List<DepartmentArea> departmentAreas = new ArrayList<>();
        /*admin  zkmt*/
        if(departmentName == null){
            /*分页*/
            PageHelper.startPage(currentPage,3);
            List<DepartmentEntity> list=departmentService.queryAll();
            PageInfo<DepartmentEntity> pageInfo=new PageInfo<>(list);
            model.addAttribute("pages",pageInfo);
            departmentAreas=departmentAreaService.findAll();
            model.addAttribute("area",departmentAreas);
        }else{
            /*left下拉区域信息   departmentAreas*/
            DepartmentArea departmentArea=new DepartmentArea();
            DepartmentEntity departmentEntity=new DepartmentEntity();
            departmentEntity.setName(departmentName);
            departmentArea.setAreaName(departmentService.queryDepartmentLimitOne(departmentEntity).getArea());
            System.out.println(departmentArea.toString());
            if(departmentArea != null){
                departmentAreas.add(departmentArea);
            }
            /*right 部门信息 list*/
            DepartmentEntity departmentEntityNew=new DepartmentEntity();
            departmentEntityNew.setName(departmentName);
            List<DepartmentEntity> list=departmentService.queryByCond(departmentEntityNew);
            model.addAttribute("area",departmentAreas);
            /*分页*/
            PageHelper.startPage(currentPage,3);
            PageInfo<DepartmentEntity> pageInfo=new PageInfo<>(list);
            model.addAttribute("pages",pageInfo);
        }
        return "bumen";
    }

    /**
     * @desc: 新增部门信息
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("insert")
    @ResponseBody
    public String insertDepartment(String name, Integer deType, String area, String loc, String phone, String people,String username,String password) {
        if(name == null || deType == null || area ==null || loc== null || people == null || phone == null || username == null ||
        name == "" || area == "" ||  loc== ""  || people == "" || phone == "" || password =="" ){
            logger.info("新增部门信息失败!");
            return "error";
        }
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setCreatedtime(new Date());
        departmentEntity.setUpdatetime(new Date());
        departmentEntity.setName(name);
        departmentEntity.setArea(area);
        departmentEntity.setType(deType);
        departmentEntity.setLoc(loc);
        departmentEntity.setPhone(phone);
        departmentEntity.setPeople(people);
        departmentEntity.setUsername(username);
        departmentEntity.setPassword(password);
        departmentService.insertDepartment(departmentEntity);
        return "success";
    }
     /**
       * @desc: 查询
       * @param: id
       * @return:
       * @auther: czx
       */
    @RequestMapping("queryById")
    @ResponseBody
    public Object queryById(Integer id){
        DepartmentEntity departmentEntity=departmentService.queryDepartmentById(id);
        return departmentEntity;
    }

     /**
       * @desc: 根据区域查询部门
       * @param: 区域名称
       * @return: 局部刷新  bumen.html
       * @auther: czx
       */
    @RequestMapping("queryByArea")
    public String queryById1(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,String area,Model model,HttpSession session){
        String departmentName = user(session);
        PageHelper.startPage(currentPage,3);
        DepartmentEntity departmentEntity=new DepartmentEntity();
        List<DepartmentEntity> list=new LinkedList<DepartmentEntity>();
        if(departmentName == null){
            /*根据区域查询*/
            if(area != null){
                departmentEntity.setArea(area);
                list=departmentService.queryByCond(departmentEntity);
            }else {
                list=departmentService.queryAll();
            }
        }else {
            /*根据部门名称查询*/
            departmentEntity.setName(departmentName);
        }
        /*分页*/
        PageInfo<DepartmentEntity> pageInfo=new PageInfo<>(list);
        model.addAttribute("pages",pageInfo);
        return "bumen :: areabody";
    }

    /**
     * @desc: 修改部门信息
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("edit")
    @ResponseBody
    public String editDepartment(String name, Integer deType, String area, String loc, String phone, String people,String id,String username,String password) {
        if(name == null || deType == null || area ==null || loc== null || people == null || phone == null || id == null || username == null || password == null
            || name == "" || area == "" ||  loc== ""  || people == "" || phone == "" || id == "" || username == "" || password == ""  ){
            logger.info("修改部门信息失败!");
            return "error";
        }
        Integer i=Integer.valueOf(id).intValue();
        DepartmentEntity departmentEntity=departmentService.queryDepartmentById(i);
        departmentEntity.setUpdatetime(new Date());
        departmentEntity.setName(name);
        departmentEntity.setArea(area);
        departmentEntity.setType(deType);
        departmentEntity.setLoc(loc);
        departmentEntity.setPhone(phone);
        departmentEntity.setPeople(people);
        departmentEntity.setUsername(username);
        departmentEntity.setPassword(password);
        departmentService.updateDepartmentById(departmentEntity);
        return "success";
    }

    /**
     * @desc: 判断是否是admin或者中科绵投登录
     * @param:
     * @return:  null(admin  zkmt) or 登录的单位名称
     * @auther: czx
     */
    public  String user(HttpSession session){
        User user = (User) session.getAttribute("user");
        String username=user.getUsername();
        if("admin".equals(username) || "zkmt".equals(username)){
            return null;
        }
        DepartmentEntity departmentEntity=new DepartmentEntity();
        departmentEntity.setUsername(username);
        System.out.println(departmentEntity.toString());
        List<DepartmentEntity> departmentEntityNew= departmentService.queryByCond(departmentEntity);
        if(departmentEntityNew != null){
            return  departmentEntityNew.get(0).getName();
        }
        return null;
    }

}

