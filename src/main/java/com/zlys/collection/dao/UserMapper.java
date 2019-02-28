package com.zlys.collection.dao;


import com.zlys.collection.entity.User;
import org.apache.ibatis.annotations.*;
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

    @Insert("insert into user( username , password ) values(#{username}, #{password})")
    Integer insert(@Param("username") String username,@Param("password") String password);

    @Select("select uid from user where username = #{username}")
    Integer selectByUsername(String username);

    @Update("update user set password = #{password} WHERE username = #{username} ")
    Integer  update(@Param("username") String username,@Param("password") String password);
}
