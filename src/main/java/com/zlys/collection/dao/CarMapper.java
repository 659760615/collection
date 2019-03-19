package com.zlys.collection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import com.zlys.collection.entity.CarEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-03-18 10:07:04
 */
@Repository
@Mapper
public interface CarMapper {

	Integer insertSelective(CarEntity entity);
	
	int insertRecords(@Param("records") List<CarEntity> records);

	CarEntity queryLimitOne(CarEntity entity);

	List<CarEntity> queryByCond(CarEntity entity);

	List<CarEntity> queryAll();
	
	CarEntity queryById(@Param("id") Integer id);

	List<CarEntity> queryByIds(@Param("keys") List<Integer> ids);
	
	int updateCarById(CarEntity entity);
	
	int deleteCarById(@Param("id") Integer id);
	
}
