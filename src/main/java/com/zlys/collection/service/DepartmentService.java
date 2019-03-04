package com.zlys.collection.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.zlys.collection.entity.DepartmentEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-02-28 09:58:30
 */
@Service
public interface DepartmentService {

	Integer insertDepartment(DepartmentEntity entity);
	
	void insertDepartments(List<DepartmentEntity> records);
	
	DepartmentEntity queryDepartmentLimitOne(DepartmentEntity entity);

	List<DepartmentEntity> queryByCond(DepartmentEntity entity);

	List<DepartmentEntity> queryAll();

	DepartmentEntity queryDepartmentById(Integer id);
	
	List<DepartmentEntity> queryDepartmentByIds(List<Integer> ids);
	
	boolean updateDepartmentById(DepartmentEntity entity);
	
	boolean deleteDepartmentById(Integer id);

	List<String> queryAllName();

}
