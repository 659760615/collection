package com.zlys.collection.dao;

import com.zlys.collection.entity.DepartmentArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:CZX
 * @create:2019-02-27 9:45
 * @desc:
 **/
@Repository
@Mapper
public interface DepartmentAreaMapper {
     /**
       * @desc: 获取所有区域信息(涪城区,游仙区,教育园...)
       * @param:
       * @return:
       * @auther: czx
       */
    @Select("SELECT\n" +
            "department_area.id id,\n" +
            "department_area.area_name areaName,\n" +
            "department_area.area_number areaName\n" +
            "FROM\n" +
            "department_area\n")
    public List<DepartmentArea> findAll();
}
