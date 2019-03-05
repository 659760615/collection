package com.zlys.collection.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlys.collection.entity.DriverEntity;
import com.zlys.collection.service.DepartmentService;
import com.zlys.collection.service.DriverService;
import com.zlys.collection.service.RoleCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author:CZX
 * @create:2019-03-04 10:22
 * @desc:
 **/
@Controller
@RequestMapping("driver")
public class DriverController {

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
    public String quanxian(Model model){
        /*所有的部门信息*/
        List<String> departments=departmentService.queryAllName();
        model.addAttribute("department",departments);

        /*all*/

        /*区域*/
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
    public Object  allDriver(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,Model model){
        PageHelper.startPage(currentPage,3);
        List<DriverEntity> list=driverService.queryAll();
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

}
