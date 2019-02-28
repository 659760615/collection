package com.zlys.collection.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author:CZX
 * @create:2019-02-28 11:29
 * @desc:
 **/
@Repository
@Mapper
public interface UserRoleMapper {

    @Insert("insert into user_role ( uid , rid ) values(#{uid}, 1)")
    void insert(@Param("uid") Integer uid, @Param("rid") Integer rid);
}
