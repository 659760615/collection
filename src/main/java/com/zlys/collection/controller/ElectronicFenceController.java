package com.zlys.collection.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlys.collection.entity.ElectronicFenceEntity;
import com.zlys.collection.service.DepartmentService;
import com.zlys.collection.service.ElectronicFenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:CZX
 * @create:2019-03-20 8:58
 * @desc: 系统管理_电子围栏
 **/
@Controller
@RequestMapping("fence")
public class ElectronicFenceController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(ElectronicFenceController.class);

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ElectronicFenceService electronicFenceService;

    /**
     * @desc: 围栏管理  view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_c")
    public String quyu(Model model,HttpSession session){
        String departmentName = user(session);
        List<String> list=new LinkedList<>();
        if(departmentName == null){
            /*所有的部门信息*/
            list=departmentService.queryAllName();
        }else{
            /*区域*/
            list.add(departmentName);
        }
        model.addAttribute("departments",list);
        return "quyu";
    }

    /**
     * @desc: 编辑围栏管理  view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        List<String> list=departmentService.queryAllName();
        model.addAttribute("departments",list);
        ElectronicFenceEntity electronicFenceEntity=electronicFenceService.queryElectronicFenceById(id);
        model.addAttribute("model",electronicFenceEntity);
        return "editfence";
    }

    /**
     * @desc:  新增电子围栏 view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("addfence")
    public String addfence(Model model){
        List<String> list=departmentService.queryAllName();
        model.addAttribute("departments",list);
        return "addfence";
    }


    /**
     * @desc:  新增电子围栏
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("addFenceTrue")
    @ResponseBody
    public Object addFenceTrue(String allfence,String name,String department,String remark){
        ElectronicFenceEntity electronicFenceEntity=new ElectronicFenceEntity();
        electronicFenceEntity.setName(name);
        electronicFenceEntity.setDepartment(department);
        electronicFenceEntity.setFence(allfence);
        electronicFenceEntity.setRemark(remark);
        electronicFenceEntity.setCreatedTime(new Date());
        electronicFenceEntity.setUpdateTime(new Date());
        Integer id = electronicFenceService.insertElectronicFence(electronicFenceEntity);
        if(id == 444){
            logger.info("添加电子围栏error");
            return "error";
        }
        logger.info("添加电子围栏成功!");
        return "success";
    }


    /**
     * @desc:  编辑电子围栏
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("editFenceTrue")
    @ResponseBody
    public Object editFenceTrue(Integer id,String allfence,String name,String department,String remark){
        ElectronicFenceEntity electronicFenceEntity=new ElectronicFenceEntity();
        electronicFenceEntity.setId(id);
        electronicFenceEntity.setName(name);
        electronicFenceEntity.setDepartment(department);
        electronicFenceEntity.setFence(allfence);
        electronicFenceEntity.setRemark(remark);
        electronicFenceEntity.setUpdateTime(new Date());
        boolean down = electronicFenceService.updateElectronicFenceById(electronicFenceEntity);
        if(!down){
            logger.info("编辑电子围栏error");
            return "error";
        }
        logger.info("编辑电子围栏成功!");
        return "success";
    }

    /**
     * @desc: 所有的电子围栏基础信息
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("allfence")
    @ResponseBody
    public Object allfence(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, String dName, HttpSession session){
        String departmentName = user(session);
        PageHelper.startPage(currentPage,8);
        List<ElectronicFenceEntity> list=new LinkedList<>();
        ElectronicFenceEntity electronicFenceEntity=new ElectronicFenceEntity();
        if(departmentName == null){
            if(dName == null){
                /*所有公司的车辆信息*/
                list=electronicFenceService.queryAll();
            }else{
                electronicFenceEntity.setDepartment(dName);
                list=electronicFenceService.queryByCond(electronicFenceEntity);
            }
        }else{
            System.out.println(departmentName);
            electronicFenceEntity.setDepartment(departmentName);
            list=electronicFenceService.queryByCond(electronicFenceEntity);
        }
        PageInfo<ElectronicFenceEntity> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
