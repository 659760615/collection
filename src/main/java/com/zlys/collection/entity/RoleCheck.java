package com.zlys.collection.entity;

import lombok.Data;

/**
 * @author:CZX
 * @create:2019-02-27 16:56
 * @desc: 角色考核基础信息表
 **/
@Data
public class RoleCheck {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**角色考核项*/
    private String name;

    /**角色考核内容*/
    private String checkName;
}
