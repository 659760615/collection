package com.zlys.collection.controller;

import com.zlys.collection.dao.DepartmentMapper;
import com.zlys.collection.entity.DepartmentEntity;
import com.zlys.collection.entity.User;
import com.zlys.collection.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:CZX
 * @create:2019-03-05 20:27
 * @desc: 公用
 **/
@Controller
public class BaseController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * @desc: 判断是否是admin或者中科绵投登录
     * @param:
     * @return:  null(admin  zkmt) or 登录的单位名称
     * @auther: czx
     */
    public String user(HttpSession session){
        User user = (User) session.getAttribute("user");
        String username=user.getUsername();
        if("admin".equals(username) || "zkmt".equals(username)){
            return null;
        }
        DepartmentEntity departmentEntity=new DepartmentEntity();
        departmentEntity.setUsername(username);
        List<DepartmentEntity> departmentEntityNew= departmentService.queryByCond(departmentEntity);
        if(departmentEntityNew != null){
            return  departmentEntityNew.get(0).getName();
        }
        return null;
    }
}
