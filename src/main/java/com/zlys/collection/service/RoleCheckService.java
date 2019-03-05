package com.zlys.collection.service;

import com.zlys.collection.entity.RoleCheck;

import java.util.List;

/**
 * @author:CZX
 * @create:2019-03-04 14:19
 * @desc:
 **/
public interface RoleCheckService {

    RoleCheck findByid(Integer id);

    List<RoleCheck> findAll();
}
