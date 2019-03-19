package com.zlys.collection.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlys.collection.entity.CarEntity;
import com.zlys.collection.entity.DepartmentArea;
import com.zlys.collection.entity.DriverEntity;
import com.zlys.collection.service.CarService;
import com.zlys.collection.service.DepartmentAreaService;
import com.zlys.collection.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:CZX
 * @create:2019-03-18 9:24
 * @desc: 系统管理_车辆管理
 **/
@Controller
@RequestMapping("car")
public class CarController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentAreaService departmentAreaService;

    /**
     * @desc: 系统管理_车辆管理 view
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("system_f")
    public String cheliang(HttpSession session, Model model){
        String departmentName = user(session);
        List<String> departments=new LinkedList<>();
        List<DepartmentArea> areas=departmentAreaService.findAll();
        if(departmentName == null){
            /*所有的部门信息*/
            departments=departmentService.queryAllName();
        }else{
            /*区域*/
            departments.add(departmentName);
        }
        model.addAttribute("departments",departments);
        model.addAttribute("areas",areas);
        return "cheliang";
    }

     /**
       * @desc: 获取车辆管理基础信息
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("allCar")
    @ResponseBody
    public Object allCar(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, HttpSession session,String dName){
        String departmentName = user(session);
        PageHelper.startPage(currentPage,8);
        List<CarEntity> list=new LinkedList<>();
        CarEntity carEntity=new CarEntity();
        if(departmentName == null){
            if(dName == null){
                /*所有公司的车辆信息*/
                list=carService.queryAll();
            }else{
                carEntity.setDepartmentName(dName);
                list=carService.queryByCond(carEntity);
            }
        }else{
            carEntity.setDepartmentName(departmentName);
            list=carService.queryByCond(carEntity);
        }
        PageInfo<CarEntity> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

     /**
       * @desc: 新增车辆信息
       * @param:
       * @return:
       * @auther: czx
       */
    @RequestMapping("insertCar")
    @ResponseBody
    public Object insertCar(String plateNumber, Integer type, String colour, String departmentArea, String departmentName, String deviceSerial, String manufacturer, String modelNum,
                            String loadCapacity, String weight, String purchasingDate, String remark, String images,String initialMileage) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date date =  formatter.parse(purchasingDate);
        CarEntity carEntity=new CarEntity();
        carEntity.setPlateNumber(plateNumber);
        carEntity.setType(type);
        carEntity.setColour(colour);
        carEntity.setDepartmentArea(departmentArea);
        carEntity.setDepartmentName(departmentName);
        carEntity.setDeviceSerial(deviceSerial);
        carEntity.setManufacturer(manufacturer);
        carEntity.setModelNum(modelNum);
        carEntity.setLoadCapacity(loadCapacity);
        carEntity.setWeight(weight);
        carEntity.setPurchasingDate(date);
        carEntity.setImages(images);
        carEntity.setRemark(remark);
        carEntity.setInitialMileage(initialMileage);
        carEntity.setCreatedtime(new Date());
        carEntity.setUpdatetime(new Date());
        System.out.println(carEntity.toString());
        if(444 == carService.insertCar(carEntity)){
            logger.info("新增车辆信息失败");
            return "error";
        }
        logger.info("新增车辆信息success");
        return "success";
    }

    /**
     * @desc: 修改车辆信息
     * @param:
     * @return:
     * @auther: czx
     */
    @RequestMapping("updateCar")
    @ResponseBody
    public Object updateCar(String plateNumber, Integer type, String colour, String departmentArea, String departmentName, String deviceSerial, String manufacturer, String modelNum,
                            String loadCapacity, String weight, String purchasingDate, String remark, String images,String initialMileage,Integer id) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date date =  formatter.parse(purchasingDate);
        CarEntity carEntity=new CarEntity();
        carEntity.setId(id);
        carEntity.setPlateNumber(plateNumber);
        carEntity.setType(type);
        carEntity.setColour(colour);
        carEntity.setDepartmentArea(departmentArea);
        carEntity.setDepartmentName(departmentName);
        carEntity.setDeviceSerial(deviceSerial);
        carEntity.setManufacturer(manufacturer);
        carEntity.setModelNum(modelNum);
        carEntity.setLoadCapacity(loadCapacity);
        carEntity.setWeight(weight);
        carEntity.setPurchasingDate(date);
        carEntity.setImages(images);
        carEntity.setRemark(remark);
        carEntity.setInitialMileage(initialMileage);
        carEntity.setUpdatetime(new Date());
        if(!carService.updateCarById(carEntity)){
            logger.info("修改车辆信息失败!");
            return "error";
        }
        logger.info("修改车辆信息success");
        return "success";
    }
}
