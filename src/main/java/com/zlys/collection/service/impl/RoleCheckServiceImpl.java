package com.zlys.collection.service.impl;

import com.zlys.collection.dao.RoleCheckMapper;
import com.zlys.collection.entity.RoleCheck;
import com.zlys.collection.service.RoleCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:CZX
 * @create:2019-03-04 14:20
 * @desc:
 **/
@Service
public class RoleCheckServiceImpl implements RoleCheckService {

    @Autowired
    private RoleCheckMapper roleCheckMapper;


    @Override
    public RoleCheck findByid(Integer id) {
        return roleCheckMapper.findByid(id);
    }
}
