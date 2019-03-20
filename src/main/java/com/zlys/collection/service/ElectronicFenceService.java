package com.zlys.collection.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.zlys.collection.entity.ElectronicFenceEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-03-20 10:54:11
 */
@Service
public interface ElectronicFenceService {

	Integer insertElectronicFence(ElectronicFenceEntity entity);
	
	void insertElectronicFences(List<ElectronicFenceEntity> records);
	
	ElectronicFenceEntity queryElectronicFenceLimitOne(ElectronicFenceEntity entity);

	List<ElectronicFenceEntity> queryByCond(ElectronicFenceEntity entity);

	List<ElectronicFenceEntity> queryAll();

	ElectronicFenceEntity queryElectronicFenceById(Integer id);
	
	List<ElectronicFenceEntity> queryElectronicFenceByIds(List<Integer> ids);
	
	boolean updateElectronicFenceById(ElectronicFenceEntity entity);
	
	boolean deleteElectronicFenceById(Integer id);

}
