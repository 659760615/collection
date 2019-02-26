package com.zlys.collection.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlys.collection.dao.SysUserMapper;
import com.zlys.collection.entity.SysUserEntity;
import com.zlys.collection.service.SysUserService;
/**
 * @Description:
 * @author czx
 * @date: 2019-02-26 13:50:54
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public Integer insertSysUser(SysUserEntity entity) {
	   Integer ID = null;
	   try {
			sysUserMapper.insertSelective(entity);
			ID = entity.getID();
		} catch (Exception e) {
		}
		return ID;   
	}
	
	@Override
	public void insertSysUsers(List<SysUserEntity> records) {
	   try {
	   		sysUserMapper.insertRecords(records);
	   } catch(Exception e) {
	   }
	}

	@Override
	public SysUserEntity querySysUserLimitOne(SysUserEntity entity) {
		try {
			return sysUserMapper.queryLimitOne(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<SysUserEntity> queryByCond(SysUserEntity entity) {
		try {
			return sysUserMapper.queryByCond(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<SysUserEntity> queryAll() {
		try {
			return sysUserMapper.queryAll();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public SysUserEntity querySysUserByID (Integer ID) {
		try {
			return sysUserMapper.queryByID(ID);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<SysUserEntity> querySysUserByIDs (List<Integer> IDs) {
		try {
			return sysUserMapper.queryByIDs(IDs);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateSysUserByID (SysUserEntity entity) {
		try {
			return sysUserMapper.updateSysUserByID(entity) > 0;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean deleteSysUserByID (Integer ID) {
		try {
			return sysUserMapper.deleteSysUserByID(ID) > 0;
		} catch(Exception e) {
			return false;
		}
	}
}
