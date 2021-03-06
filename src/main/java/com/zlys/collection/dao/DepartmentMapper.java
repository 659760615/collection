package com.zlys.collection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import com.zlys.collection.entity.DepartmentEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-02-28 09:58:30
 */
@Repository
@Mapper
public interface DepartmentMapper {

	Integer insertSelective(DepartmentEntity entity);
	
	int insertRecords(@Param("records") List<DepartmentEntity> records);

	DepartmentEntity queryLimitOne(DepartmentEntity entity);

	List<DepartmentEntity> queryByCond(DepartmentEntity entity);

	List<DepartmentEntity> queryAll();
	
	DepartmentEntity queryById(@Param("id") Integer id);

	List<DepartmentEntity> queryByIds(@Param("keys") List<Integer> ids);
	
	int updateDepartmentById(DepartmentEntity entity);
	
	int deleteDepartmentById(@Param("id") Integer id);

    @Select("select name from department")
    List<String> queryAllName();
}
