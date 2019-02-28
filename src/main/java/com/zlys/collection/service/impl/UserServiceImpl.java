package com.zlys.collection.service.impl;


import com.zlys.collection.dao.UserMapper;
import com.zlys.collection.entity.User;
import com.zlys.collection.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author:CZX
 * @create:2019-01-28 15:19
 * @desc:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Integer insert(String username, String password) {
        return userMapper.insert(username,password);
    }

    @Override
    public Integer selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
