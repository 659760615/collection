package com.zlys.collection.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.zlys.collection.entity.CarEntity;

/**
 * @Description:
 * @author czx
 * @date: 2019-03-18 10:07:04
 */
@Service
public interface CarService {

	Integer insertCar(CarEntity entity);
	
	void insertCars(List<CarEntity> records);
	
	CarEntity queryCarLimitOne(CarEntity entity);

	List<CarEntity> queryByCond(CarEntity entity);

	List<CarEntity> queryAll();

	CarEntity queryCarById(Integer id);
	
	List<CarEntity> queryCarByIds(List<Integer> ids);
	
	boolean updateCarById(CarEntity entity);
	
	boolean deleteCarById(Integer id);

}
