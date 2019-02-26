package com.zlys.collection.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.zlys.collection.entity.SysUserEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-02-26 13:50:54
 */
@Service
public interface SysUserService {

	Integer insertSysUser(SysUserEntity entity);
	
	void insertSysUsers(List<SysUserEntity> records);
	
	SysUserEntity querySysUserLimitOne(SysUserEntity entity);

	List<SysUserEntity> queryByCond(SysUserEntity entity);

	List<SysUserEntity> queryAll();

	SysUserEntity querySysUserByID (Integer ID);
	
	List<SysUserEntity> querySysUserByIDs (List<Integer> IDs);
	
	boolean updateSysUserByID (SysUserEntity entity);
	
	boolean deleteSysUserByID (Integer ID);

}
