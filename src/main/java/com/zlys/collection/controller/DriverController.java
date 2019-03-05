package com.zlys.collection.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlys.collection.entity.DepartmentEntity;
import com.zlys.collection.entity.DriverEntity;
import com.zlys.collection.entity.RoleCheck;
import com.zlys.collection.entity.User;
import com.zlys.collection.service.DepartmentService;
import com.zlys.collection.service.DriverService;
import com.zlys.collection.service.RoleCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:CZX
 * @create:2019-08-04 10:22
 * @desc:
 **/
@Controller
@RequestMapping("driver")
public class DriverController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(DriverController.class);


    @Autowired
    private DriverService driverService;

    @Autowired
    private RoleCheckService roleCheckService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * @desc: 系统管理_角色管理 view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_d")
    public String quanxian(Model model,HttpSession session){
        String departmentName = user(session);
        List<String> departments=new LinkedList<>();
        if(departmentName == null){
            /*所有的部门信息*/
            departments=departmentService.queryAllName();
        }else{
            /*区域*/
            departments.add(departmentName);
        }
        model.addAttribute("department",departments);
        /*all考核项目*/
        List<RoleCheck> list=roleCheckService.findAll();
        model.addAttribute("roleCheck",list);
        return "quanxian";
    }
     /**
       * @desc: 司机详细信息
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("allDriver")
    @ResponseBody
    public Object  allDriver(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, Model model, HttpSession session){
        String departmentName = user(session);
        PageHelper.startPage(currentPage,8);
        List<DriverEntity> list=new LinkedList<>();
        if(departmentName == null){
            /*all*/
            list=driverService.queryAll();
        }else {
            /*区域*/
            DriverEntity driverEntity=new DriverEntity();
            driverEntity.setDepartment(departmentName);
            list=driverService.queryByCond(driverEntity);
        }
        /*考核项*/
        list.stream().forEach(item -> {
            StringBuilder names=new StringBuilder();
                String driverCheck = item.getDriverCheck();
                if(driverCheck != null){
                    for(int i=0;i<driverCheck.length();i++)
                    { char c=driverCheck.charAt(i);
                        String s=roleCheckService.findByid(c-'0').getName();
                        names.append(s+'.');
                    }
                    item.setDriverCheck(names.toString());
                }
        });
        PageInfo<DriverEntity> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }


    /**
     * @desc: 新增司机
     * @param:
     * @return:
     * @auther: czx
     */
    @PostMapping("insertDriver")
    @ResponseBody
    public String  InserDriver(String iName,String iCard,Integer iSex,String iDepartment,Integer iType){
        DriverEntity driverEntity=new DriverEntity();
        driverEntity.setName(iName);
        driverEntity.setIdCrad(iCard);
        driverEntity.setDepartment(iDepartment);
        driverEntity.setSex(iSex);
        driverEntity.setType(iType);
        driverEntity.setCreatedTime(new Date());
        driverEntity.setUpdateTime(new Date());
        Integer id=driverService.insertDriver(driverEntity);
        if(id == 0){
            return "error";
        }
        return "success";
    }

    /**
     * @desc: 编辑司机基础信息
     * @param:
     * @return:
     * @auther: czx
     */
    @PostMapping("editDriver")
    @ResponseBody
    public String  editDriver(String name,String idCard,Integer sex,String department,Integer type,Integer id){
        DriverEntity driverEntity=new DriverEntity();
        driverEntity.setId(id);
        driverEntity.setType(type);
        driverEntity.setSex(sex);
        driverEntity.setUpdateTime(new Date());
        driverEntity.setName(name);
        driverEntity.setIdCrad(idCard);
        driverEntity.setDepartment(department);
        System.out.println(driverEntity.toString());
        boolean updateDriverById=driverService.updateDriverById(driverEntity);
        if(!updateDriverById){
            logger.info("修改error");
            return "error";
        }
        logger.info("修改成功!");
        return "success";
    }
     /**
       * @desc: 查询考核项
       * @param: id
       * @return:
       * @auther: czx
       */
     @RequestMapping("findCheckById")
     @ResponseBody
    public Object findCheckById(Integer id){
        DriverEntity driverEntity=driverService.queryDriverById(id);
        String checks=driverEntity.getDriverCheck();
        List<Character> list=new LinkedList<>();
         if(checks != null){
             for(int i=0;i<checks.length();i++) {
                 char c=checks.charAt(i);
                 list.add(c);
             }
         }
        return list;
    }


    /**
     * @desc: 新增司机考核项
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("insertCheck")
    @ResponseBody
    public Object insertCheck(String checkName,Integer id){
        DriverEntity driverEntity=driverService.queryDriverById(id);
        driverEntity.setUpdateTime(new Date());
        driverEntity.setDriverCheck(checkName);
        driverService.updateDriverById(driverEntity);
        return "success";
    }

    /**
     * @desc: 删除司机信息
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("deleteDriver")
    @ResponseBody
    public Object deleteDriver(Integer id){
        driverService.deleteDriverById(id);
        return "success";
    }


}
