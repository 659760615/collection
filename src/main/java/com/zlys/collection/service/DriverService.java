package com.zlys.collection.service;

import com.zlys.collection.entity.DriverEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author czx
 * @date: 2019-03-04 10:35:06
 */
@Service
public interface DriverService {

	Integer insertDriver(DriverEntity entity);
	
	void insertDrivers(List<DriverEntity> records);
	
	DriverEntity queryDriverLimitOne(DriverEntity entity);

	List<DriverEntity> queryByCond(DriverEntity entity);

	List<DriverEntity> queryAll();

	DriverEntity queryDriverById(Integer id);
	
	List<DriverEntity> queryDriverByIds(List<Integer> ids);
	
	boolean updateDriverById(DriverEntity entity);
	
	boolean deleteDriverById(Integer id);

}
