package com.zlys.collection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import com.zlys.collection.entity.SysUserEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-02-26 13:50:54
 */
@Repository
@Mapper
public interface SysUserMapper {

	Integer insertSelective(SysUserEntity entity);
	
	int insertRecords(@Param("records") List<SysUserEntity> records);

	SysUserEntity queryLimitOne(SysUserEntity entity);

	List<SysUserEntity> queryByCond(SysUserEntity entity);

	List<SysUserEntity> queryAll();
	
	SysUserEntity queryByID (@Param("ID") Integer ID);

	List<SysUserEntity> queryByIDs(@Param("keys") List<Integer> IDs);
	
	int updateSysUserByID (SysUserEntity entity);
	
	int deleteSysUserByID (@Param("ID") Integer ID);
	
}
