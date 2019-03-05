package com.zlys.collection.dao;

import com.zlys.collection.entity.RoleCheck;
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
public interface RoleCheckMapper {

    @Select("select id,name,check_name checkName from role_check where id = #{id}")
    RoleCheck findByid(Integer id);

    @Select("select id,name,check_name checkName from role_check")
    List<RoleCheck> findAll();
}
