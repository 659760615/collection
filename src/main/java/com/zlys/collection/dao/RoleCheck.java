package com.zlys.collection.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:CZX
 * @create:2019-02-27 17:03
 * @desc:
 **/
@Repository
@Mapper
public interface RoleCheck {

//    @Select()
    List<RoleCheck> findAll();
}
