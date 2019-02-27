package com.zlys.collection.entity;

import lombok.Data;

/**
 * @author:CZX
 * @create:2019-02-27 9:47
 * @desc:
 **/
@Data
public class DepartmentArea {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**区域名称*/
    private String areaName;

    /**区域编号*/
    private String areaNumber;
}
