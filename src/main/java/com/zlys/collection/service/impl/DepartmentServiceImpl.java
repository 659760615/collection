package com.zlys.collection.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlys.collection.dao.DepartmentMapper;
import com.zlys.collection.entity.DepartmentEntity;
import com.zlys.collection.service.DepartmentService;
/**
 * @Description:
 * @author czx
 * @date: 2019-02-26 15:21:11
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public Integer insertDepartment(DepartmentEntity entity) {
	   Integer id = null;
	   try {
			departmentMapper.insertSelective(entity);
			id = entity.getId();
		} catch (Exception e) {
		}
		return id;   
	}
	
	@Override
	public void insertDepartments(List<DepartmentEntity> records) {
	   try {
	   		departmentMapper.insertRecords(records);
	   } catch(Exception e) {
	   }
	}

	@Override
	public DepartmentEntity queryDepartmentLimitOne(DepartmentEntity entity) {
		try {
			return departmentMapper.queryLimitOne(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<DepartmentEntity> queryByCond(DepartmentEntity entity) {
		try {
			return departmentMapper.queryByCond(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<DepartmentEntity> queryAll() {
		try {
			return departmentMapper.queryAll();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public DepartmentEntity queryDepartmentById (Integer id) {
		try {
			return departmentMapper.queryById(id);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<DepartmentEntity> queryDepartmentByIds (List<Integer> ids) {
		try {
			return departmentMapper.queryByIds(ids);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateDepartmentById (DepartmentEntity entity) {
		try {
			return departmentMapper.updateDepartmentById(entity) > 0;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean deleteDepartmentById (Integer id) {
		try {
			return departmentMapper.deleteDepartmentById(id) > 0;
		} catch(Exception e) {
			return false;
		}
	}
}
