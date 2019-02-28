package com.zlys.collection.service;


import com.zlys.collection.entity.User;

/**
 * @author:CZX
 * @create:2019-01-28 15:18
 * @desc:
 **/
public interface UserService {
    User findByUsername(String username);

    Integer insert(String username,String  password);

    Integer selectByUsername(String username);

}