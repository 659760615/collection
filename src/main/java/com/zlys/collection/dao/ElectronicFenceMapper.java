package com.zlys.collection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import com.zlys.collection.entity.ElectronicFenceEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-03-20 10:54:11
 */
@Repository
@Mapper
public interface ElectronicFenceMapper {

	Integer insertSelective(ElectronicFenceEntity entity);
	
	int insertRecords(@Param("records") List<ElectronicFenceEntity> records);

	ElectronicFenceEntity queryLimitOne(ElectronicFenceEntity entity);

	List<ElectronicFenceEntity> queryByCond(ElectronicFenceEntity entity);

	List<ElectronicFenceEntity> queryAll();
	
	ElectronicFenceEntity queryById(@Param("id") Integer id);

	List<ElectronicFenceEntity> queryByIds(@Param("keys") List<Integer> ids);
	
	int updateElectronicFenceById(ElectronicFenceEntity entity);
	
	int deleteElectronicFenceById(@Param("id") Integer id);
	
}
