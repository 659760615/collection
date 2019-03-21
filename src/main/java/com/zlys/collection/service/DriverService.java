package com.zlys.collection.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.zlys.collection.entity.DriverEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-03-21 09:36:31
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

	void updateDriverTimeById(Integer id);

}
