package com.zlys.collection.service.impl;

import com.zlys.collection.dao.DepartmentAreaMapper;
import com.zlys.collection.entity.DepartmentArea;
import com.zlys.collection.service.DepartmentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:CZX
 * @create:2019-02-27 9:58
 * @desc:
 **/
@Service
public class DepartmentAreaServiceImpl implements DepartmentAreaService {

    @Autowired
    private DepartmentAreaMapper departmentAreaMapper;

    @Override
    public List<DepartmentArea> findAll() {
        return departmentAreaMapper.findAll();
    }
}
