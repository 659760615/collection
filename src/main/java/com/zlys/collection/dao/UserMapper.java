package com.zlys.collection.dao;


import com.zlys.collection.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author:CZX
 * @create:2019-01-28 15:17
 * @desc:
 **/
@Repository
@Mapper
public interface UserMapper {
    User findByUsername(@Param("username") String username);
}
