package com.zlys.collection.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlys.collection.dao.ElectronicFenceMapper;
import com.zlys.collection.entity.ElectronicFenceEntity;
import com.zlys.collection.service.ElectronicFenceService;
/**
 * @Description:
 * @author czx
 * @date: 2019-03-20 10:54:11
 */
@Service
public class ElectronicFenceServiceImpl implements ElectronicFenceService {

	@Autowired
	private ElectronicFenceMapper electronicFenceMapper;

	@Override
	public Integer insertElectronicFence(ElectronicFenceEntity entity) {
	   Integer id = null;
	   try {
			electronicFenceMapper.insertSelective(entity);
			id = entity.getId();
		} catch (Exception e) {
	       return 444;
		}
		return id;   
	}
	
	@Override
	public void insertElectronicFences(List<ElectronicFenceEntity> records) {
	   try {
	   		electronicFenceMapper.insertRecords(records);
	   } catch(Exception e) {
	   }
	}

	@Override
	public ElectronicFenceEntity queryElectronicFenceLimitOne(ElectronicFenceEntity entity) {
		try {
			return electronicFenceMapper.queryLimitOne(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<ElectronicFenceEntity> queryByCond(ElectronicFenceEntity entity) {
		try {
			return electronicFenceMapper.queryByCond(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<ElectronicFenceEntity> queryAll() {
		try {
			return electronicFenceMapper.queryAll();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public ElectronicFenceEntity queryElectronicFenceById (Integer id) {
		try {
			return electronicFenceMapper.queryById(id);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<ElectronicFenceEntity> queryElectronicFenceByIds (List<Integer> ids) {
		try {
			return electronicFenceMapper.queryByIds(ids);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateElectronicFenceById (ElectronicFenceEntity entity) {
		try {
			return electronicFenceMapper.updateElectronicFenceById(entity) > 0;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean deleteElectronicFenceById (Integer id) {
		try {
			return electronicFenceMapper.deleteElectronicFenceById(id) > 0;
		} catch(Exception e) {
			return false;
		}
	}
}
