package com.zlys.collection.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlys.collection.dao.CarMapper;
import com.zlys.collection.entity.CarEntity;
import com.zlys.collection.service.CarService;
/**
 * @Description:
 * @author czx
 * @date: 2019-03-18 10:07:04
 */
@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper carMapper;

	@Override
	public Integer insertCar(CarEntity entity) {
	   Integer id = null;
	   try {
			carMapper.insertSelective(entity);
			id = entity.getId();
		} catch (Exception e) {
	       return 444;
		}
		return id;   
	}
	
	@Override
	public void insertCars(List<CarEntity> records) {
	   try {
	   		carMapper.insertRecords(records);
	   } catch(Exception e) {
	   }
	}

	@Override
	public CarEntity queryCarLimitOne(CarEntity entity) {
		try {
			return carMapper.queryLimitOne(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<CarEntity> queryByCond(CarEntity entity) {
		try {
			return carMapper.queryByCond(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<CarEntity> queryAll() {
		try {
			return carMapper.queryAll();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public CarEntity queryCarById (Integer id) {
		try {
			return carMapper.queryById(id);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<CarEntity> queryCarByIds (List<Integer> ids) {
		try {
			return carMapper.queryByIds(ids);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateCarById (CarEntity entity) {
		try {
			return carMapper.updateCarById(entity) > 0;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean deleteCarById (Integer id) {
		try {
			return carMapper.deleteCarById(id) > 0;
		} catch(Exception e) {
			return false;
		}
	}
}
