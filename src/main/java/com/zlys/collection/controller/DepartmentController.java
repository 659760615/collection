package com.zlys.collection.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlys.collection.entity.DepartmentArea;
import com.zlys.collection.entity.DepartmentEntity;
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
    public String bumen(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, Model model){
        /*获取区域信息*/
        List<DepartmentArea> departmentAreas = departmentAreaService.findAll();
        model.addAttribute("area",departmentAreas);
        /*分页*/
        PageHelper.startPage(currentPage,8);
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
        departmentService.insertDepartment(departmentEntity);
        logger.info("新增部门信息suucess!");
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
    public String queryById1(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,String area,Model model){
        DepartmentEntity departmentEntity=new DepartmentEntity();
        departmentEntity.setArea(area);
        List<DepartmentEntity> list=departmentService.queryByCond(departmentEntity);

        /*分页*/
        PageHelper.startPage(currentPage,8);
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
    public String editDepartment(String name, Integer deType, String area, String loc, String phone, String people,String id) {
        if(name == null || deType == null || area ==null || loc== null || people == null || phone == null || id == null
            || name == "" || area == "" ||  loc== ""  || people == "" || phone == "" || id == ""){
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
        departmentService.updateDepartmentById(departmentEntity);
        logger.info("修改部门信息suucess!");
        return "success";
    }

}

