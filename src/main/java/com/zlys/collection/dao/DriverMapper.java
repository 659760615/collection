package com.zlys.collection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import com.zlys.collection.entity.DriverEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-03-21 09:36:31
 */
@Repository
@Mapper
public interface DriverMapper {

	Integer insertSelective(DriverEntity entity);
	
	int insertRecords(@Param("records") List<DriverEntity> records);

	DriverEntity queryLimitOne(DriverEntity entity);

	List<DriverEntity> queryByCond(DriverEntity entity);

	List<DriverEntity> queryAll();
	
	DriverEntity queryById(@Param("id") Integer id);

	List<DriverEntity> queryByIds(@Param("keys") List<Integer> ids);
	
	int updateDriverById(DriverEntity entity);

	void updateDriverTimeById(@Param("id") Integer id);
	
	int deleteDriverById(@Param("id") Integer id);
	
}
