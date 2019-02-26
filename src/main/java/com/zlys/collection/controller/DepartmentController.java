package com.zlys.collection.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlys.collection.entity.DepartmentEntity;
import com.zlys.collection.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author:CZX
 * @create:2019-02-26 15:24
 * @desc:
 **/
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * @desc: 系统管理_部门管理 view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_e")
    public String bumen(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, Model model){
        PageHelper.startPage(currentPage,6);
        List<DepartmentEntity> list=departmentService.queryAll();
        PageInfo<DepartmentEntity> pageInfo=new PageInfo<>(list);
        model.addAttribute("pages",pageInfo);
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
    public String insertDepartment(String name, Integer deType, String area, String loc, String phone, String people) {
        if(name == null || deType == null || area ==null || loc== null || people == null || phone == null ||
        name == "" || area == "" ||  loc== ""  || people == "" || phone == ""){
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
}

